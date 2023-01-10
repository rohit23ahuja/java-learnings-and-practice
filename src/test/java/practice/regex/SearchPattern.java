package practice.regex;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class SearchPattern {

	//@Test
	public void givenSignedUrl_ThenSearchFileName() {
		String signedUrl = "https://storage.googleapis.com/flatfile-storage/2021-11-24/flatfile-2021-11-24-10%3A07%3A09.680374861.csv?"
				+ "x-goog-signature=20a3ad0a33a0a237e5a480791fa9088ab35395bea258f7ae210582aae4d96d04d9d93e3b30b70dd9a1da49c6b2d8184865b"
				+ "1fb6ac0282c4e1b9735876c2dcb63d64ab0bac606ce4a25d58855c16b7346870f973382562464a0b8aca198c44af15218286f729ab9c0fcf6ca27"
				+ "cbe82327651ddb92d414a9bc05627362b28a77220a7aadd3d1a1e9999c3669f7fb66dd19c98049636d007939898083afbd3fa6c1496ccb1873a391"
				+ "e7d9cd63c87c46624c052d9729932717c4779decd88786a5076918b5b81ad88ce8fe60ef322e2b79f1ae9cebad1f40119a536e3280c0d73819f031f"
				+ "f40706245393b5add1e7ffb1fedb82cacc081f31652984404c111c97ca3&x-goog-algorithm=GOOG4-RSA-SHA256&x-goog-credential=svc-gdp%40"
				+ "gdp-dev-ne28d2.iam.gserviceaccount.com%2F20211129%2Feurope-west1%2Fstorage%2Fgoog4_request&x-goog-date=20211129T182352Z&x-"
				+ "goog-expires=600&x-goog-signedheaders=host";
		Pattern pattern = Pattern.compile("flatfile-\\d\\d\\d\\d-\\d\\d-\\d\\d-.*\\.csv");
		Matcher matcher = pattern.matcher(signedUrl);
		String result = null;
		if (matcher.find()) {
			result = matcher.group();
		}
		assertEquals("flatfile-2021-11-24-10%3A07%3A09.680374861.csv", result);

	}

	@Test
	public void givenSignedUrlOfJsonFile_ThenExtractFileName() {
		String signedUrl = "https://storage.googleapis.com/sunshine-storage-dev/19E136FDE1854868B0BAD40404183A34_diffrequest.json?GoogleAccessId=svc-gdp@gdp-dev-ne28d2.iam.gserviceaccount.com&Expires=1640250427&Signature=Bzds9h7mJPqDUEMljuOjGb1gnVQLn8RD2JwunCFBnTuzj4CoGPYnb3oGunh1oRNTVGx3LZZvO1WbKflq%2FZmunI4eaylVMFoJJfFYvxMwmIWclIqBNMVMhTLlVMKcoL3VgxfySyou5URTgtx0MOZgWHQfRWu8OYrQCDbGRZrxSDPkfpjROeiTE25xOcQmXWRLSeum7UPY5cqSQrdhwpDIPo4e9P3Kkfy3GeRzuTMtrcT63aYY37icEJAZPzghzMOnVb9hihsAl7U4a7nNHTONQqn7YtXVXhhAPdeZMWIdmXrWt2Mvuez6Mmhh1%2FkNTLDfUy804QGY%2FIlKu20leK5QuA%3D%3D";
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]+_diffrequest.json");
		Matcher matcher = pattern.matcher(signedUrl);
		String result = null;
		if (matcher.find()) {
			result = matcher.group();
		}
		System.out.println(result);
		assertEquals("19E136FDE1854868B0BAD40404183A34_diffrequest.json", result);
	}

}
