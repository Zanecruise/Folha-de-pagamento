package com.example.output;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.controller.ConfirmController;
import com.example.demo.controller.OpenFileController;
import com.example.demo.joins.FuncionarioEmpregadorJoin;
import com.example.demo.repository.AdicionaisRepository;
import com.example.demo.repository.AtributosFolhaRepository;
import com.example.demo.repository.DataFolha;
import com.example.demo.repository.EnderecoToString;
import org.springframework.context.ApplicationContext;
import org.apache.poi.ss.util.*;

/**
 * Classe com objetivo de criar e emitir a folha de pagamento
 */
@Component
public class FolhaDePagamento implements ApplicationContextAware {
    private static ApplicationContext context;
    private boolean folhaEmitida;
    private final OpenFileController openFileController;

    public FolhaDePagamento(OpenFileController openFileController) {
        this.openFileController = openFileController;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public void emitirFolha(int id_funcionario) {
        List<Map<String, String>> mapList = buildMaps(); // montar os vetores
        String pathBasePlanilha = "form-holerite.xlsx"; // arquivo base

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(pathBasePlanilha)) {
            if (inputStream == null) {
                throw new FileNotFoundException("Arquivo não encontrado: " + pathBasePlanilha);
            }

            // pega as info do excel e as celulas pra inserir
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            FuncionarioEmpregadorJoin funcionarioEmpregador = context.getBean(FuncionarioEmpregadorJoin.class);
            Map<String, Object> joinFuncionarioEmpregador = funcionarioEmpregador.join(id_funcionario);

            setTopoFolha(mapList, joinFuncionarioEmpregador, sheet, context);
            setMeioFolha(mapList, id_funcionario, sheet, context);
            setBaseFolha(mapList, id_funcionario, sheet, context);

            // cria o nome do novo arquivo
            String nomeArquivo = joinFuncionarioEmpregador.get("nome_funcionario").toString().trim();
            String caminhoExcel = "output/" + nomeArquivo + ".xlsx"; // local em que o novo arquivo vai ser armazenado

            File outputFile = new File(caminhoExcel); // cria um novo excel ja no caminho final
            outputFile.getParentFile().mkdirs(); // caso não tenha a pasta output ele cria
            // salvar novo excel
            salvarExcel(workbook, outputFile);
            // baixar excel
            baixarArquivo(caminhoExcel);

        } catch (IOException e) {
            System.out.println("Erro ao manipular o arquivo Excel: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void setTopoFolha(List<Map<String, String>> mapList, Map<String, Object> joinFuncionarioEmpregador,
            XSSFSheet sheet, ApplicationContext context2) {
        // PUXAR O ENDERECO EMPREGADOR
        EnderecoToString endereco = context2.getBean(EnderecoToString.class);
        String enderecoString = endereco.ederecoToString((int) joinFuncionarioEmpregador.get("id_empregador"));
        setCellValue(sheet, mapList.get(0).get("endereco"), enderecoString);
        // nome funcionario
        String nomeFuncionarioString = joinFuncionarioEmpregador.get("id_funcionario") + " - "
                + joinFuncionarioEmpregador.get("nome_funcionario");
        setCellValue(sheet, mapList.get(0).get("nome_funcionario"), nomeFuncionarioString);

        String salarioBase = (String) joinFuncionarioEmpregador.get("salario_base");
        setCellValue(sheet, "L5", salarioBase);

        for (Map.Entry<String, String> entry : mapList.get(0).entrySet()) {
            String keyMap2 = entry.getKey(); // key map 2
            String cellReference = entry.getValue(); // celula excel

            if (joinFuncionarioEmpregador.containsKey(keyMap2)) {
                setCellValue(sheet, cellReference, joinFuncionarioEmpregador.get(keyMap2));
            } else {
                System.out.println("Valor não encontrado no mapa 1: " + keyMap2);
            }
        }
    }

    public void setMeioFolha(List<Map<String, String>> mapList, int id_funcionario,
            XSSFSheet sheet, ApplicationContext context2) {
        AdicionaisRepository adicionaisRepository = context2.getBean(AdicionaisRepository.class);
        List<String> descricaoAdicionais = adicionaisRepository.selectDescricao(id_funcionario);
        double[] refAdicionais = adicionaisRepository.selectValoresAdicionais(id_funcionario, "referencia");
        double[] provAdicionais = adicionaisRepository.selectValoresAdicionais(id_funcionario, "provento");
        double[] descAdicionais = adicionaisRepository.selectValoresAdicionais(id_funcionario, "desconto");

        for (int i = 0; i < refAdicionais.length; i++) {
            setCellValue(sheet, mapList.get(1).get("id_descricao") + (i + 9), (i + 1));
            setCellValue(sheet, mapList.get(1).get("index_descricao") + (i + 9), (i + 1));
            setCellValue(sheet, mapList.get(1).get("descricao_adicionais") + (i + 9), descricaoAdicionais.get(i));
            setCellValue(sheet, mapList.get(1).get("referencia_adicionais") + (i + 9), refAdicionais[i]);
            setCellValue(sheet, mapList.get(1).get("provento_adicionais") + (i + 9), provAdicionais[i]);
            setCellValue(sheet, mapList.get(1).get("desconto_adicionais") + (i + 9), descAdicionais[i]);
        }

    }

    public void setBaseFolha(List<Map<String, String>> mapList, int id_funcionario, XSSFSheet sheet,
            ApplicationContext context2) {
        AtributosFolhaRepository atributosFolhaRepository = context2.getBean(AtributosFolhaRepository.class);
        Map<String, Object> atributos = atributosFolhaRepository.selectAtributosFolha(id_funcionario);
        // data folha
        DataFolha dataFolha = context2.getBean(DataFolha.class);
        String dataFormat = dataFolha.dataFormat(id_funcionario);
        setCellValue(sheet, mapList.get(2).get("data_folha"), dataFormat);

        for (Map.Entry<String, String> entry : mapList.get(2).entrySet()) {
            String keyMap = entry.getKey(); // key map 2
            String cellReference = entry.getValue(); // celula excel

            if (atributos.containsKey(keyMap)) {
                setCellValue(sheet, cellReference, atributos.get(keyMap));
            } else {
                System.out.println("Valor não encontrado no mapa 1: " + keyMap);
            }
        }

    }

    public void salvarExcel(XSSFWorkbook workbook, File outputFile) throws IOException {
        try (FileOutputStream fileOut = new FileOutputStream(outputFile)) {
            workbook.write(fileOut); // salva novo arquivo
            setFolhaEmitida(true);
            ConfirmController confirm = new ConfirmController();
            confirm.confirmarEmissao();
            System.out.println("Arquivo salvo com sucesso em: " + outputFile.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo Excel: " + e.getMessage());
            setFolhaEmitida(false);
            e.printStackTrace();
            throw e;
        }
    }

    public ResponseEntity<Resource> baixarArquivo(String caminhoDoArquivo) throws IOException {
        return openFileController.downloadFile(caminhoDoArquivo);
    }

    public void setCellValue(XSSFSheet sheet, String cellReference, Object value) {
        CellReference ref = new CellReference(cellReference);
        int rowIndex = ref.getRow();
        int columnIndex = ref.getCol();
        XSSFRow row = sheet.getRow(rowIndex);
        if (row == null) {
            row = sheet.createRow(rowIndex);
        }
        XSSFCell cell = row.getCell(columnIndex);
        if (cell == null) {
            cell = row.createCell(columnIndex);
        }
        cell.setCellValue(value.toString());
    }

    /**
     * @return Retorna uma lista de Maps, mapeando todos os campos que devem ser
     *         preenchidos na folha de pagamento, com base no arquivo Excel.
     */
    public static List<Map<String, String>> buildMaps() {
        List<Map<String, String>> mapList = new ArrayList<>();

        mapList.add(buildSection1());
        mapList.add(buildSection2());
        mapList.add(buildSection3());

        return mapList;
    }

    // Mapeamento das informações da parte superior da folha de pagamento:
    // Empregador e Funcionário
    private static Map<String, String> buildSection1() {
        Map<String, String> map = new HashMap<>();
        map.put("nome_empregador", "B2");

        map.put("endereco", "B4");
        map.put("cnpj", "L4");
        map.put("nome_funcionario", "C5");
        map.put("cbo", "H5");
        map.put("salario_base", "L5"); // ARRUMAR ISSO
        map.put("salario_base", "C30");
        map.put("genero", "C6");
        map.put("cargo", "H6");
        map.put("Salario_Familia", "L6");
        map.put("admissao", "C7");
        map.put("funcao", "H7");
        return map;
    }

    // Mapeamento das informaç~oes da parte central da folha de pagamento:
    // Adicionais, proventos, descontos etc..
    private static Map<String, String> buildSection2() {
        Map<String, String> map = new HashMap<>();
        map.put("id_descricao", "B");
        map.put("index_descricao", "C");
        map.put("descricao_adicionais", "D");
        map.put("referencia_adicionais", "F");
        map.put("provento_adicionais", "H");
        map.put("desconto_adicionais", "K");

        return map;
    }

    // Mapeamento das informações da parte inferior da folha de pagamento:
    // Valor líquido, FGTS, INSS etc...
    private static Map<String, String> buildSection3() {
        Map<String, String> map = new HashMap<>();
        map.put("data_folha", "L3");
        map.put("Total_vencimento", "H25");
        map.put("Total_desconto", "K25");
        map.put("Total_liquido", "K26");
        map.put("Base_calculo_INSS", "E30");
        map.put("Base_calculo_FGTS", "F30");
        map.put("Base_calculo_IRRF", "J30");
        map.put("Faixa_IRRF", "L30");
        return map;
    }

    public boolean isFolhaEmitida() {
        return folhaEmitida;
    }

    public void setFolhaEmitida(boolean folhaEmitida) {
        this.folhaEmitida = folhaEmitida;
    }

}
