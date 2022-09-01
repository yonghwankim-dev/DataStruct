package Stack.CollectionFramework;



import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

import static org.assertj.core.api.Assertions.*;


public class StackTest {
    @Test
    public void add() throws Exception{
        //given
        Stack<Integer> stack = new Stack<>();
        //when
        stack.add(1);
        stack.add(2);
        stack.add(3);
        //then
        assertThat(stack).isEqualTo(new ArrayList<>(Arrays.asList(1,2,3)));
    }

    @Test
    public void pop() throws Exception{
        //given
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        //when
        int actual1 = stack.pop();
        int actual2 = stack.pop();
        int actual3 = stack.pop();
        //then
        assertThat(actual1).isEqualTo(3);
        assertThat(actual2).isEqualTo(2);
        assertThat(actual3).isEqualTo(1);
    }
    
    @Test
    public void push() throws Exception{
        //given
        Stack<Integer> stack = new Stack<>();

        //when
        int actual1 = stack.push(1);
        int actual2 = stack.push(2);
        int actual3 = stack.push(3);
        int actual4 = stack.pop();
        int actual5 = stack.pop();
        int actual6 = stack.pop();

        //then
        assertThat(actual1).isEqualTo(1);
        assertThat(actual2).isEqualTo(2);
        assertThat(actual3).isEqualTo(3);
        assertThat(actual4).isEqualTo(3);
        assertThat(actual5).isEqualTo(2);
        assertThat(actual6).isEqualTo(1);
    }


}
