package com.interviewcake;

/*
 * My cake shop is so popular, I'm adding some tables and hiring wait staff so folks can have a cute sit-down cake-eating experience.
 * I have two registers: one for take-out orders, and the other for the other folks eating inside the cafe. 
 * All the customer orders get combined into one list for the kitchen, where they should be handled first-come, first-served.
 */
public class FirstComeFirstServed {

	public static void main(String[] args) {

		int[] taOrders = { 1, 3, 5 };
		int[] diOrders = { 2, 4, 6 };
		int[] servedOrders = { 1, 2, 4, 6, 5, 3 };

		System.out.println(isFirstComeFirstServed(taOrders, diOrders, servedOrders));

		taOrders = new int[] { 17, 8, 24 };
		diOrders = new int[] { 12, 19, 2 };
		servedOrders = new int[] { 17, 8, 12, 19, 24, 2 };

		System.out.println(isFirstComeFirstServed(taOrders, diOrders, servedOrders));
	}

	public static boolean isFirstComeFirstServed(int[] takeAway, int[] dinneIn, int[] served) {
		int taIndex = 0;
		int diIndex = 0;

		for (int serv : served) {

			if (taIndex < takeAway.length && serv == takeAway[taIndex]) {
				taIndex++;
			} else if (diIndex < dinneIn.length && serv == dinneIn[diIndex]) {
				diIndex++;
			} else {
				return false;
			}
		}

		if (taIndex != takeAway.length && diIndex != dinneIn.length) {
			return false;
		}

		return true;
	}

}
