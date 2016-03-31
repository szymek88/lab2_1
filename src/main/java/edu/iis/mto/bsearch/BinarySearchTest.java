package edu.iis.mto.bsearch;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void shouldFindElementInSingleElementSequence() {
		int[] seq = new int[] {4};
		SearchResult result = BinarySearch.search(4, seq);
		
		assertThat(result.isFound(), equalTo(true));
	}

	@Test
	public void shouldNotFindElementInSingleElementSequence() {
		int[] seq = new int[] {8};
		SearchResult result = BinarySearch.search(4, seq);
		
		assertThat(result.isFound(), equalTo(false));
	}
	
	@Test
	public void shouldFindElementAtFirstIndexInMultipleElementSequence() {
		int[] seq = new int[] {1,2,3};
		SearchResult result = BinarySearch.search(1, seq);
		
		assertThat(result.isFound(), equalTo(true));
	}
	
	@Test
	public void shouldFindElementInTheMiddleInMultipleElementSequence() {
		int[] seq = new int[] {1,2,3};
		SearchResult result = BinarySearch.search(2, seq);
		
		assertThat(result.isFound(), equalTo(true));
	}
	
	@Test
	public void shouldFindElementAtLastIndexInMultipleElementSequence() {
		int[] seq = new int[] {1,2,3};
		SearchResult result = BinarySearch.search(3, seq);
		
		assertThat(result.isFound(), equalTo(true));
	}
	
	@Test
	public void shouldNotFindElementInMultipleElementSequence() {
		int[] seq = new int[] {1,2,3};
		SearchResult result = BinarySearch.search(4, seq);
		
		assertThat(result.isFound(), equalTo(false));
	}
}
