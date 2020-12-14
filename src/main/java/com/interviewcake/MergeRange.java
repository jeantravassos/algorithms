package com.interviewcake;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class MergeRange {

	public static void main(String[] args) {

		List<Meeting> meetings = new ArrayList<>();
		meetings.add(new Meeting(0, 1));
		meetings.add(new Meeting(3, 5));
		meetings.add(new Meeting(4, 8));
		meetings.add(new Meeting(10, 12));
		meetings.add(new Meeting(9, 10));

		meetings = mergeRange(meetings);
		meetings.forEach(System.out::println);
	}

	public static List<Meeting> mergeRange(List<Meeting> meetings) {
		
		Collections.sort(meetings, new Comparator<Meeting>() {
			@Override
			public int compare(Meeting m1, Meeting m2) {
				return m1.getStartTime() - m2.getStartTime();
			}
		});

		List<Meeting> mergedList = new ArrayList<>();
		mergedList.add(meetings.get(0));
		
		for(Meeting meeting : meetings) {

			Meeting lastMergedMeeting = mergedList.get(mergedList.size() - 1);
			
			if (meeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
				lastMergedMeeting.setEndTime(Math.max(meeting.getEndTime(), lastMergedMeeting.getEndTime()));
			} else {
				mergedList.add(meeting);
			}
		}
		
		return mergedList;
	}

}
