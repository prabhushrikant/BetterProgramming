package designpatterns.gof.singleton;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import com.shrikant.designpatterns.gof.singleton.SingletonExample;
import org.junit.Test;

public class SingletonExampleTest {

  @Test
  public void singleton_returns_same_instance_on_subsequent_calls() {

    //given
    SingletonExample singletonExample1 = SingletonExample.getInstance();

    //when
    SingletonExample singletonExample2 = SingletonExample.getInstance();

    //then
    assertThat("Both instances should be same", singletonExample1, is(singletonExample2));
  }
}
