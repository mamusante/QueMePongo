import java.util.List;
import java.util.Random;


public class Randoms {

  private static final Random random = new Random();

  public static <T> T atRandom(List<T> list) {
    return list.get(random.nextInt(list.size()));
  }
}
