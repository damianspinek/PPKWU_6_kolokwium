package kolokwium;

import java.util.Scanner;

import library.FileExtensionResolver;
import library.FileOpener;
import library2.AesFileDecryptor;
import library2.AesFileEncryptor;
import library2.checksum.ChecksumAlgorithm;
import library2.checksum.Md5Algorithm;
import library2.file.FileReader;
import library2.file.FileReaderImpl;
import library2.file.FileWriter;
import library2.file.FileWriterImpl;

public class Kolokwium {
	public static void main(String[] args) throws Exception {
		System.out.println("Podaj scie¿kê do pliku");
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine();
		
		String key = "ak5v92jgh7dr1k4f";
		
		FileReader fileReader = new FileReaderImpl();
		FileWriter fileWriter = new FileWriterImpl();
		//EncryptAlgorithm encryptAlgorithm = new AesEncryptor();
		ChecksumAlgorithm md5Algorithm = new Md5Algorithm();
		
		AesFileEncryptor aesFileEncryptor = new AesFileEncryptor(fileReader, fileWriter);
		AesFileDecryptor aesFileDecryptor = new AesFileDecryptor(fileReader, fileWriter);
		
		aesFileEncryptor.encrypt(path,
				"C:\\Users\\student\\Desktop\\zaszyfrowany.png", key);
		
		//C:\Users\student\Desktop\logo@2x.png
		//C:\Users\student\Downloads\PPKWU_5_Library_3-master\PPKWU_5_Library_3-master\PPKWU_5_Library_3\Yamaha-TG100-Whistle-C5.wav
		System.out.println("Podaj klucz do szyfrowania");
		key = scanner.nextLine();
	
		/*aesFileDecryptor.decrypt("C:\\Users\\student\\Desktop\\zaszyfrowany.png",
				"C:\\Users\\student\\Desktop\\odszyfrowany.png",
				key);*/
		
		System.out.println(FileExtensionResolver.getFileExtension(path));
		FileOpener.openFile(path);
		scanner.close();
	}
}
