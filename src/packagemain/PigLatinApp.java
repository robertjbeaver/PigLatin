package packagemain;

import consolehelper.util.Console;

public class PigLatinApp {
	//static final String vowels = "aeioyu";
	public static void main(String[] args) {
		System.out.println("Welcome to the pig latin translator!\n");
		String input = Console.getString("Enter a line: ").toLowerCase();
		String[] line = input.split(" ");
		
		String latinV = "way";
		String latinC = "ay";
		for(int i = 0; i < line.length; i++) {
			if(isSpecial(line[i])) {
				System.out.print(line[i] + " ");
			}
			else if(isVowel(line[i].charAt(0))) {
				line[i] += latinV + " ";
				System.out.print(line[i]);
			} else {
				int indexOfV = indexOfVowel(line[i]);
				String cons = line[i].substring(0, indexOfV);
				line[i] = line[i].substring(indexOfV) + cons + latinC + " ";
				System.out.print(line[i]);
			}
		}
		
		System.out.println();
		
	}
	public static int indexOfVowel(String s) {
		int rv = 0;
		for(int i = 0; i < s.length(); i++) {	
			if ("aeiouy".indexOf(s.substring(i, i+1) ) >= 0){
				if(i==0 && s.charAt(0)=='y') {
					continue;
				} else {
					rv = i;
					break;
				}
				
			}
		} return rv;
	}
	public static boolean isVowel(char c) {
		  return "aeiou".indexOf(c) != -1;
		}
	public static boolean isSpecial(String s) {
		for(int i =0; i < s.length(); i++) {
			if("1234567890!@#$%^&*".indexOf(s.substring(i, i+1)) != -1) {
				return true;
			}
			}
		return false;
		}
		
	}

