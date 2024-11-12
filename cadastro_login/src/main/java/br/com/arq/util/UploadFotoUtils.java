package br.com.arq.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFotoUtils {

    private static final String UPLOAD_DIR = "src/main/resources/static/image/fotoImovel/";

    protected static String getExtension(String filename) {
        if (filename == null || !filename.contains(".")) {
            return ".jpg"; // Padrão para JPG se não conseguir determinar a extensão
        }
        return filename.substring(filename.lastIndexOf(".")).toLowerCase();
    }

    public static byte[] uploadFoto(byte[] fotoBytes) throws IOException {
        if (fotoBytes == null || fotoBytes.length == 0) {
            throw new IOException("O arquivo está vazio.");
        }

        // Obter a extensão do arquivo (assumindo que você tenha uma maneira de determinar a extensão)
        String extension = ".jpg";  // Você pode melhorar isso para gerar a extensão com base no tipo da imagem

        // Cria o diretório de upload, se não existir
        Path uploadPath = Paths.get(UPLOAD_DIR);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Define o nome do arquivo com um timestamp para garantir que seja único
        String fileName = System.currentTimeMillis() + extension;

        // Caminho do arquivo
        Path filePath = uploadPath.resolve(fileName);

        // Salva os bytes da foto
        Files.write(filePath, fotoBytes);

        // Retorna os bytes do arquivo (se necessário)
        return fotoBytes;
    }
}
