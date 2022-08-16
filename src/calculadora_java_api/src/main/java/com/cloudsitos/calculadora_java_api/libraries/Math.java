package com.cloudsitos.calculadora_java_api.libraries;

import java.util.Stack;

public class Math { 
    private static String transfer(String mathStr) {
		// marca la salida
		StringBuilder result = new StringBuilder();
		// 1. Inicializa una pila de operadores.
		Stack<Character> stack = new Stack<>();
		if (mathStr == null || mathStr.length() == 0) {
			return null;
		}
		char[] arr = mathStr.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			// 2. Lee un carácter a la vez de izquierda a derecha desde la cadena de entrada de la expresión aritmética.
			char s = arr[i];
			// 3. Si el carácter actual es un operando, complételo directamente en la expresión de sufijo.
			if (Character.isDigit(s)) {
				result.append(s);
			}
			// 4. Si el carácter actual es (paréntesis izquierdo, empújelo a la pila del operador (definido en el primer paso).
			else if ('(' == s) {
				stack.push(s);
			}
			// 5. Si el personaje actual es un operador, entonces
			else if ('+' == s || '-' == s || '*' == s || '/' == s) {
				if (!stack.isEmpty()) {
					char stackTop = stack.pop();
					// Cuando la precedencia de este operador es mayor que el elemento superior de la pila, empuje este operador a la pila de operadores
					if (compare(s, stackTop)) {
						stack.push(stackTop);
						stack.push(s);
					}
					// De lo contrario, muestre el operador superior a la expresión postfix y empuje el operador actual a la pila. Regrese al paso 2.
					else {
						result.append(stackTop);
						stack.push(s);
					}
				}
				// 5.1. Cuando la pila del operador está vacía, se empuja sobre la pila del operador.
				else {
					stack.push(s);
				}
			}
			// 6. Si el carácter actual es un paréntesis derecho, pop repetidamente el elemento superior de la pila a la expresión de sufijo hasta que el elemento superior de la pila sea el paréntesis izquierdo (y descarte el paréntesis izquierdo de la pila.
			else if (s == ')') {
				while (!stack.isEmpty()) {
					char item = stack.pop();
					if (item != '(') {
						result.append(item);
					} else {
						break;
					}
				}
			}
		}
		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		return result.toString();
	}

    // Prioridad de comparación
    private static boolean compare(char s, char item) {
  		if (item == '(') {
  			return true;
  		}
  		if (s == '*' || s == '/') {
  			if (item == '+' || item == '-') {
  				return true;
  			}
  		}
  		return false;
  	}

    public static int calculate(String transferToPostfix) {
        transferToPostfix = transfer(transferToPostfix);
		Stack<Integer> stack = new Stack<>();
		char[] c = transferToPostfix.toCharArray();
		int a, b;
		for (int i = 0; i < c.length; i++) {
			switch (c[i]) {
			case '+':
				a = Integer.valueOf(stack.pop().toString());
				b = Integer.valueOf(stack.pop().toString());
				stack.push(b + a);
				break;
			case '-':
				a = Integer.valueOf(stack.pop().toString());
				b = Integer.valueOf(stack.pop().toString());
				stack.push(b - a);
				break;
			case '*':
				a = Integer.valueOf(stack.pop().toString());
				b = Integer.valueOf(stack.pop().toString());
				stack.push(b * a);
				break;
			case '/':
				a = Integer.valueOf(stack.pop().toString());
				b = Integer.valueOf(stack.pop().toString());
				stack.push(b / a);
				break;

			default:
				Character d = c[i];
				stack.push(Integer.valueOf(d.toString()));
				break;
			}
		}
		return stack.pop();
	}
}


