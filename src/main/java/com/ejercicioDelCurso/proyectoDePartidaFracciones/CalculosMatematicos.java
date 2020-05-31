package com.ejercicioDelCurso.proyectoDePartidaFracciones;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class CalculosMatematicos {
	public static boolean esPar(int numero) {
		return numero % 2 == 0;
	}

	/*
	 * 
	 * Este método se usa para descomponer un número en sus factores primos Genera
	 * un mapa ordenado donde cada clave es un divisor primo del número y cuyo valor
	 * es el número de veces que incluye ese divisor primo.
	 * 
	 */
	public static SortedMap<Integer, Integer> divisores(int numero) {
		SortedMap<Integer, Integer> divisores = new TreeMap<Integer, Integer>();
		int numeroIntermedio = numero;
		Integer divisor = 2;
		while (numeroIntermedio >= divisor) {
			while (numeroIntermedio % divisor == 0) {
				Integer clave = divisor;
				divisores.putIfAbsent(divisor, 0);
				divisores.computeIfPresent(clave, (key, val) -> (val + 1));
				numeroIntermedio = numeroIntermedio / divisor;
			}

			divisor++;
		}
		return divisores;
	}

	public static ArrayList<Integer> listaDePrimosHasta(int numero) {
		ArrayList<Integer> listaDePrimos = new ArrayList<Integer>();
		listaDePrimos.add(1);
		listaDePrimos.add(2);
		listaDePrimos.add(3);
		for (int i = 5; i <= numero; i += 2) {
			if (esPrimo(i))
				listaDePrimos.add(i);
		}
		return listaDePrimos;
	}

	public static int potencia(int base, int exponente) {

		int resul = 1;
		if (exponente > 0)
			resul = base * potencia(base, exponente - 1);
		return resul;
	}

	public static boolean esPrimo(int numero) {

		boolean primo = true;
		int divisor = 3;
		if (numero != 2 && numero % 2 == 0)
			primo = false;
		while (primo && divisor <= Math.sqrt(numero)) {
			if (numero % divisor == 0)
				primo = false;
			divisor += 2;
		}
		return primo;
	}

	
		public static int maximoComunDivisor(int numero1, int numero2) {
	    int maxComDiv = 1;
	    for (int i = 1; i <= numero1 && i <= numero2; i++) {
	        if (numero1 % i == 0 && numero2 % i == 0) {
	            maxComDiv = i;
	        }
	    }
	    return maxComDiv;
	}
	
	public static int minimoComunMultiplo(int numero1, int numero2) {
		int minComMul=1;
		int maxComDiv;
		maxComDiv=MisMetodos.maximoComunDivisor(numero1, numero2);	   
		 minComMul= (numero1 * numero2) / maxComDiv;
		return minComMul;
		
	}
	
	
	public static int multiplicar(Fraccion a, Fraccion b){
     	Fraccion c=new Fraccion();
     	c.num=a.num*b.num;
     	c.den=a.den*b.den;
     	return c;
  	}
	
	public static int dividir(Fraccion a, Fraccion b){
     	return new Fraccion(a.num*b.den, a.den*b.num);
 	}
	
	 static void factor(int numero)
     {
          int num = 2;

          while(numero!=1)
          {
               while(numero%num==0)
               {
                    System.out.println(num);
                    numero /= num;
               }
          }
     }
	
}
