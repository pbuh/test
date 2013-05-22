package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import play.mvc.Controller;
import play.mvc.Http.MultipartFormData;
import play.mvc.Http.MultipartFormData.FilePart;
import play.mvc.Result;

public class Upload extends Controller {

	public static Result upload() {
		return ok(views.html.upload.render());
	}

	public static Result done() {
		MultipartFormData body = request().body().asMultipartFormData();
		FilePart pbuh = body.getFile("pbuh");
		if (pbuh != null) {
			String fileName = pbuh.getFilename();
			String contentType = pbuh.getContentType();
			File file = pbuh.getFile();
			try {
				copy(file, new File("uploads/" + fileName));
			} catch (Exception ex) {
				return ok(ex.getMessage());
			}
			return ok("File uploaded");
		} else {
			flash("error", "Missing file");
			return redirect(routes.Application.index());
		}
	}

	private static void copy(File source, File destination) throws IOException {
		InputStream src = new FileInputStream(source);

		OutputStream dest = new FileOutputStream(destination);

		byte buf[] = new byte[1024];
		int read = -1;
		while ((read = src.read(buf)) != -1)
			dest.write(buf, 0, read);

		src.close();
		dest.close();
	}
}
