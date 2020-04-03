package net.itinajero.app.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class Util {

	/**
	 * Método que regresa una lista de Strings con las fechas siguientes, según el
	 * parámetro count
	 * 
	 * @param count
	 * @return Lista de Fechas en String
	 */
	public static List<String> getNextDays(int count) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

		// Fecha del dia
		Date start = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);
		Date endDate = cal.getTime();

		GregorianCalendar gcal = new GregorianCalendar();

		gcal.setTime(start);
		List<String> nextDays = new ArrayList<String>();

		while (!gcal.getTime().after(endDate)) {
			Date d = gcal.getTime();
			gcal.add(Calendar.DATE, 1);
			nextDays.add(sdf.format(d));
		}
		return nextDays;
	}

	/**
	 * Metodo para guardar ficheros en el disco duro
	 * 
	 * @param multiPart
	 * @param request
	 * @return
	 */
	public static String guardarImagen(MultipartFile multiPart, HttpServletRequest request) {
		// Obtenemos el nombre original del fichero
		String nombreOriginal = multiPart.getOriginalFilename();

		// Quitamos los espacios en blanco
		nombreOriginal = nombreOriginal.replace(" ", "-");

		// creamos el nombre final
		String nombreFinal = randomAlphaNumeric(8) + "-" + nombreOriginal;
		nombreFinal = nombreFinal.trim().toLowerCase();

		// Obtenemos la ruta absoluta del directorio de imagenes
		String rutaFinal = request.getServletContext().getRealPath("/resources/images/");

		try {

			// Formamos el nombre del archivo para guardarlo en el disco
			File imageFile = new File(rutaFinal + nombreFinal);

			// System.out.println(imageFile.getAbsolutePath());

			if (!imageFile.exists()) {
				imageFile.mkdirs();
			}

			// Guardamos en el disco
			multiPart.transferTo(imageFile);

			// retornamos el nombre final para guardarlo en el objeto
			return nombreFinal;

		} catch (IOException e) {
			System.err.println(new Date() + " [Error guardado file] " + e.getMessage());
			return null;
		}

	}

	/**
	 * Crear nombre variables aleatorios
	 * 
	 * @param count
	 * @return
	 */
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "abcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder builder = new StringBuilder();
		while (count-- != 0) {
			int character = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(character));
		}
		return builder.toString();
	}

}
