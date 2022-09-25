package modernjavainaction.chap03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAround {

  // /resoures/modernjavainaction/cha03 의 경로에서 data.txt파일을 가져온다.
  private static final String FILE = ExecuteAround.class.getResource("./data.txt").getFile();

  public static void main(String... args) throws IOException {
    // 더 유연하게 리팩토링할 메서드
    String result = processFileLimited();
    System.out.println(result);

    System.out.println("---");

    String oneLine = processFile((BufferedReader b) -> b.readLine());
    System.out.println(oneLine);
    System.out.println("---");
    String twoLines = processFile((BufferedReader b) -> b.readLine() + b.readLine());
    System.out.println(twoLines);

    String tree = processFile((BufferedReader b) -> b.readLine() + b.readLine() + b.readLine());
    System.out.println(tree);
  }

  // 파일읽기
  public static String processFileLimited() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
      return br.readLine();
    }
  }

  // 인터페이스를 이용해서 파일 읽기
  public static String processFile(BufferedReaderProcessor p) throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
      return p.process(br);
    }
  }

  public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
  }

}
