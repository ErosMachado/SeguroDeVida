package com.sementesdobrasil.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DataUtils {

    // Método para tentar converter a string para LocalDate ou LocalDateTime com diferentes padrões
    public static LocalDate converterDataNascimento(String dataNascimento) {
        // Definindo os formatos possíveis para a data
        DateTimeFormatter[] formatos = new DateTimeFormatter[] {

            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") // Formato com hora
        };

        for (DateTimeFormatter formato : formatos) {
            try {
                // Tentamos parsear a data com o formato atual
                if (formato.toString().equals("yyyy-MM-dd HH:mm:ss")) {
                    return LocalDate.parse(dataNascimento, formato);
                } else {
                    // Se for outro formato (com hora), tratamos com LocalDateTime e retornamos LocalDate
                    LocalDateTime dataHora = LocalDateTime.parse(dataNascimento, formato);
                    return dataHora.toLocalDate(); // Convertendo para LocalDate, ignorando a hora
                }
            } catch (DateTimeParseException e) {
                // Se falhar, tentamos o próximo formato
                continue;
            }
        }

        // Se nenhum formato funcionar, retorna null ou lança uma exceção, dependendo do seu tratamento
        throw new IllegalArgumentException("(D)Formato de data inválido: " + dataNascimento);
    }
}