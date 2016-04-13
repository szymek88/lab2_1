package edu.iis.mto.bsearch;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class BinarySearchTest {
	
	private static final int NOT_FOUND = -1;
	private static final int FIRST_INDEX = 0;

	@Test
	public void shouldFindElementInSingleElementSequence() {
		int key = 4;
		int[] seq = new int[] {key};
		SearchResult result = BinarySearch.search(key, seq);
		
		assertThat(result.isFound(), equalTo(true));
		assertThat(seq[result.getPosition()], equalTo(key));
	}

	@Test
	public void shouldNotFindElementInSingleElementSequence() {
		int[] seq = new int[] {8};
		SearchResult result = BinarySearch.search(4, seq);
		
		assertThat(result.isFound(), equalTo(false));
		assertThat(result.getPosition(), equalTo(NOT_FOUND));
	}
	
	@Test
	public void shouldFindElementAtFirstIndexInMultipleElementSequence() {
		int key = 1;
		int[] seq = new int[] {key,2,3};
		SearchResult result = BinarySearch.search(key, seq);
		
		assertThat(result.isFound(), equalTo(true));
		assertThat(seq[result.getPosition()], equalTo(key));
		assertThat(result.getPosition(), equalTo(FIRST_INDEX));
	}
	
	@Test
	public void shouldFindElementInTheMiddleInMultipleElementSequence() {
		int key = 3;
		int[] seq = new int[] {1,2,key,4,5};
		SearchResult result = BinarySearch.search(key, seq);
		
		assertThat(result.isFound(), equalTo(true));
		assertThat(seq[result.getPosition()], equalTo(key));
		assertThat(result.getPosition(), equalTo(seq.length/2));
	}
	
	@Test
	public void shouldFindElementAtLastIndexInMultipleElementSequence() {
		int key = 4;
		int[] seq = new int[] {1,2,3,key};
		SearchResult result = BinarySearch.search(key, seq);
		
		assertThat(result.isFound(), equalTo(true));
		assertThat(seq[result.getPosition()], equalTo(key));
		assertThat(result.getPosition(), equalTo(seq.length - 1));
	}
	
	@Test
	public void shouldNotFindElementInMultipleElementSequence() {
		int key = 5;
		int[] seq = new int[] {1,2,3,4};
		SearchResult result = BinarySearch.search(key, seq);
		
		assertThat(result.isFound(), equalTo(false));
		assertThat(result.getPosition(), equalTo(NOT_FOUND));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void shouldThrowIllegalArgumentException() {
		int key = 4;
		int[] seq = new int[0];
		SearchResult result = BinarySearch.search(key, seq);
	}
}
