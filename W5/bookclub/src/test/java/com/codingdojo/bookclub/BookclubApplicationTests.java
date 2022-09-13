package com.codingdojo.bookclub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookclubApplicationTests {

	@Test
	void contextLoads() {
			int[] nums = {2,5,5,11};
			int target = 4;

	        int[] solution = new int[2];
	        for(int i = 0; i < nums.length; i++){
	        	System.out.println("this is i" + i);
	            for(int j = 1; j < nums.length; j++) {
		        	System.out.println("this is j" + j);
	                int sum = nums[i] + nums[j];
	                if(target == sum) {
	                    solution[0] = i;
	                    solution[1] = j;
	                    break;
	                }
	            }
	           break;
	        }
	        System.out.println(solution[0]);
	        System.out.println(solution[1]);

	}

}
