package cryptopals1.pkg1;

import java.util.ArrayList;
import java.util.Scanner;

public class Cryptopals11 {

    public static void main(String[] args) {
        
        char B64[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O',
            'P','Q','R','S','T','U','V','W','X','Y','Z','a','b','c','d','e','f','g',
            'h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y',
            'z','0','1','2','3','4','5','6','7','8','9','+','/'};
        
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> index = new ArrayList<Integer>();
        String hex_str;
        
        System.out.print("Enter hex string :");
        hex_str = input.nextLine();
        
        if(check_hex(hex_str)){
            
            byte[] bytes = hexToText(hex_str).getBytes();
            String binaries = byteToBinary(bytes);
            index = binaryToB64(binaries);
            
            for(int element : index){
                    
                System.out.print(B64[element]);
            
            }
            System.out.println();
        }
        else
            System.out.println("That is not HEX.");
    }
    
    
    private static String hexToText(String hex){
    
        String temp;
        String decodedtext = "";
        
        for(int i=0;i<hex.length();i+=2){
            temp = hex.substring(i, i+2);
            decodedtext = decodedtext + (char) Integer.parseInt(temp, 16);
            
            
        }
        
        return decodedtext;
    }
    
    private static ArrayList binaryToB64(String binary){
        
        char characters[];
        ArrayList<Integer> index = new ArrayList<Integer>();
        String binarySub;
        
        if(binary.length() % 6 == 0){
            
            for(int i=0;i<binary.length();i+=6){
                
                binarySub = binary.substring(i, i+6);
                index.add(Integer.parseInt(binarySub, 2));
                
            }
            
        
        }
        
        
        return index;
        
    }
    
    private static String byteToBinary(byte[] bytes){
        
        String binary = "";
        
        for(byte element : bytes){
            
            binary = binary + String.format("%8s", Integer.toBinaryString(element)).replace(' ', '0');
            
            }
        
        
        return binary;
        
    }
    
    private static boolean check_hex(String x){
        
        final String hexes = "0123456789abcdefABCDEF";
        if(x.length() % 2 == 0){
            for(int i=0;i<x.length();i++){

                if(hexes.indexOf( x.charAt(i) ) == -1) {
                    return false;
                } 
                
            }
            
        return true;
        }
        else
            return false;
        
        
        
    }
}

