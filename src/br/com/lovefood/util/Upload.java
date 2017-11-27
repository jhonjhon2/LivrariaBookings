package br.com.lovefood.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class Upload {

	public static String Imagem(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		// define o encore
		response.setContentType("text/html;charset=UTF-8");

		// pega o caminho real do projeto
		final String path = request.getServletContext().getRealPath("resouces") + File.separator + "img";
		// resgata o arquivo do input
		final Part filePart = request.getPart("foto");
		// gera o nome aleatório usando o UUID
		final String fileName = UUID.randomUUID().toString().replace("-", "") + ".jpg";
		// escrita
		OutputStream out = null;
		// leitura
		InputStream filecontent = null;
		
		try {
			// cria o arquivo no diretório do projeto
			out = new FileOutputStream(new File(path + File.separator + fileName));
			filecontent = filePart.getInputStream();
			
			int read = 0;
			final byte[] bytes = new byte[1024];
			
			while((read = filecontent.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			
		} catch (FileNotFoundException fne) {
			fne.printStackTrace();
			System.out.println(fne.getMessage());
		} finally {
			if(out != null)
				out.close();
			if(filecontent != null)
				filecontent.close();
		}
		return fileName;
		
	}
}
