package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class LeituraAPI {
    public void teste() {
        try {
            // URL da API pública do GitHub para obter informações de um usuário
            URL url = new URL("https://api.github.com/users/epicestudar");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");


            // Verificar se a conexão foi bem-sucedida
            int status = con.getResponseCode();
            if (status != 200) {
                throw new RuntimeException("HTTP error code : " + status);
            }


            // Ler a resposta da API
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();


            // Imprimir o conteúdo da resposta
            System.out.println(content.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
