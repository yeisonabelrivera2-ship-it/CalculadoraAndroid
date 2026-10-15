package Calculadora

import java.util.Locale

class CalculadoraLogica
{
    private val partes = mutableListOf<String>()
    private var entradaActual = "0"
    private var textoPantalla = "0"
    private var esperandoNumero = true
    private var avisoMaximo = false
    private var hayError = false
    private var resultadoMostrado = false

    fun pulsar(tecla: String): String
    {
        if (tecla == "C")
        {
            partes.clear()
            entradaActual = ""
            textoPantalla = ""
            esperandoNumero = true
            avisoMaximo = false
            hayError = false
            resultadoMostrado = false
            return textoPantalla
        }

        if (avisoMaximo && tecla != "⌦")
        {
            return textoPantalla
        }

        if (hayError && tecla != "⌦" && tecla !in "0".."9")
        {
            return textoPantalla
        }

        when (tecla)
        {
            "." ->
            {
                if (hayError || resultadoMostrado)
                {
                    partes.clear()
                    entradaActual = "0,"
                    esperandoNumero = false
                    hayError = false
                    resultadoMostrado = false
                }
                else if (esperandoNumero)
                {
                    entradaActual = "0,"
                    esperandoNumero = false
                }
                else if (!entradaActual.contains(","))
                {
                    entradaActual = if (entradaActual == "-")
                    {
                        "-0,"
                    }
                    else
                    {
                        entradaActual + ","
                    }
                }
            }

            "(" ->
            {
                if (hayError || resultadoMostrado)
                {
                    partes.clear()
                    entradaActual = ""
                    hayError = false
                    resultadoMostrado = false
                }

                val puedeAbrir = partes.isEmpty() ||
                        partes.last() in listOf("+", "-", "x", "/", "(")

                if (esperandoNumero && puedeAbrir)
                {
                    partes.add("(")
                    entradaActual = ""
                    esperandoNumero = true
                }
            }

            ")" ->
            {
                val abiertos = partes.count { it == "(" }
                val cerrados = partes.count { it == ")" }

                if (abiertos > cerrados)
                {
                    if (!esperandoNumero && entradaActual.isNotEmpty() && entradaActual != "-")
                    {
                        partes.add(entradaActual)
                        partes.add(")")
                        entradaActual = ""
                        esperandoNumero = true
                    }
                    else if (esperandoNumero && entradaActual.isEmpty() && partes.isNotEmpty() &&
                        partes.last() !in listOf("(", "+", "-", "x", "/"))
                    {
                        partes.add(")")
                    }
                }
            }

            in "0".."9" ->
            {
                if (hayError || resultadoMostrado)
                {
                    partes.clear()
                    entradaActual = tecla
                    esperandoNumero = false
                    hayError = false
                    resultadoMostrado = false
                }
                else if (esperandoNumero)
                {
                    entradaActual = tecla
                    esperandoNumero = false
                }
                else
                {
                    if (entradaActual.filter { it.isDigit() }.length >= 15)
                    {
                        avisoMaximo = true
                        textoPantalla = "Máximo 15 cifras"
                        return textoPantalla
                    }

                    entradaActual = if (entradaActual == "0")
                    {
                        tecla
                    }
                    else if (entradaActual == "-0")
                    {
                        "-$tecla"
                    }
                    else
                    {
                        entradaActual + tecla
                    }
                }
            }

            "+", "-", "x", "/" ->
            {
                if (resultadoMostrado)
                {
                    partes.clear()
                    partes.add(entradaActual)
                    partes.add(tecla)
                    entradaActual = ""
                    esperandoNumero = true
                    resultadoMostrado = false
                }
                else if (entradaActual.isNotEmpty() && entradaActual != "-")
                {
                    partes.add(entradaActual)
                    partes.add(tecla)
                    entradaActual = ""
                    esperandoNumero = true
                }
                else if (entradaActual.isEmpty() && partes.isNotEmpty() && partes.last() == ")")
                {
                    partes.add(tecla)
                    esperandoNumero = true
                }
                else if (esperandoNumero && entradaActual.isEmpty() && tecla == "-")
                {
                    entradaActual = "-"
                    esperandoNumero = false
                }
                else if (esperandoNumero && partes.isNotEmpty() && partes.last() in listOf("+", "-", "x", "/"))
                {
                    if (tecla == "-")
                    {
                        entradaActual = "-"
                        esperandoNumero = false
                    }
                    else
                    {
                        partes[partes.lastIndex] = tecla
                    }
                }
                else if (partes.isEmpty() && entradaActual.isEmpty() && tecla == "-")
                {
                    entradaActual = "-"
                    esperandoNumero = false
                }
                else
                {
                    textoPantalla = "Formato no válido"
                    return textoPantalla
                }
            }

            "=" ->
            {
                if (entradaActual == "-" || (esperandoNumero && partes.isNotEmpty() && partes.last() != ")"))
                {
                    textoPantalla = "Formato no válido"
                    return textoPantalla
                }

                val expresion = if (entradaActual.isNotEmpty())
                {
                    partes.toList() + entradaActual
                }
                else
                {
                    partes.toList()
                }

                if (expresion.isNotEmpty())
                {
                    val resultado = calcular(expresion)

                    if (resultado == null)
                    {
                        hayError = true
                        partes.clear()
                        entradaActual = ""
                        esperandoNumero = true
                        return textoPantalla
                    }

                    entradaActual = formatear(resultado)
                    textoPantalla = entradaActual
                    partes.clear()
                    esperandoNumero = true
                    resultadoMostrado = true
                }
            }

            "⌦" ->
            {
                if (avisoMaximo)
                {
                    avisoMaximo = false
                    entradaActual = entradaActual.dropLast(1)
                }
                else if (hayError)
                {
                    partes.clear()
                    entradaActual = ""
                    esperandoNumero = true
                    hayError = false
                }
                else if (resultadoMostrado)
                {
                    entradaActual = ""
                    esperandoNumero = true
                    resultadoMostrado = false
                    partes.clear()
                }
                else if (entradaActual.isNotEmpty() && !esperandoNumero)
                {
                    entradaActual = entradaActual.dropLast(1)
                    esperandoNumero = entradaActual.isEmpty()
                }
                else if (partes.isNotEmpty())
                {
                    val ultimo = partes.removeAt(partes.lastIndex)

                    if (ultimo !in listOf("(", ")", "+", "-", "x", "/"))
                    {
                        entradaActual = ultimo.dropLast(1)
                        esperandoNumero = entradaActual.isEmpty()
                    }
                    else
                    {
                        entradaActual = ""
                        esperandoNumero = true
                    }
                }
                else
                {
                    entradaActual = ""
                    esperandoNumero = true
                }
            }
        }

        textoPantalla = construirPantalla()
        return textoPantalla
    }

    private fun construirPantalla(): String
    {
        val elementos = partes.toMutableList()

        if (entradaActual.isNotEmpty())
        {
            elementos.add(entradaActual)
        }

        return elementos.joinToString(" ")
    }

    private fun calcular(expresion: List<String>): Double?
    {
        class Analizador
        {
            private var indice = 0

            fun calcularExpresion(): Double?
            {
                val resultado = sumarRestar() ?: return null

                if (indice != expresion.size)
                {
                    return null
                }

                if (!resultado.isFinite())
                {
                    textoPantalla = "Número demasiado grande"
                    return null
                }

                return resultado
            }

            private fun sumarRestar(): Double?
            {
                var valor = multiplicarDividir() ?: return null

                while (indice < expresion.size &&
                    (expresion[indice] == "+" || expresion[indice] == "-"))
                {
                    val operador = expresion[indice]
                    indice++

                    val siguiente = multiplicarDividir() ?: return null
                    valor = if (operador == "+") valor + siguiente else valor - siguiente
                }

                return valor
            }

            private fun multiplicarDividir(): Double?
            {
                var valor = atomico() ?: return null

                while (indice < expresion.size &&
                    (expresion[indice] == "x" || expresion[indice] == "/"))
                {
                    val operador = expresion[indice]
                    indice++

                    val siguiente = atomico() ?: return null

                    valor = if (operador == "x")
                    {
                        valor * siguiente
                    }
                    else
                    {
                        if (siguiente == 0.0)
                        {
                            textoPantalla = "No se puede dividir entre 0"
                            return null
                        }

                        valor / siguiente
                    }
                }

                return valor
            }

            private fun atomico(): Double?
            {
                if (indice >= expresion.size)
                {
                    return null
                }

                val parte = expresion[indice]

                if (parte == "(")
                {
                    indice++
                    val valor = sumarRestar() ?: return null

                    if (indice >= expresion.size || expresion[indice] != ")")
                    {
                        return null
                    }

                    indice++
                    return valor
                }

                if (parte == "-")
                {
                    indice++
                    return -(atomico() ?: return null)
                }

                if (parte in listOf("+", "-", "x", "/", ")"))
                {
                    return null
                }

                indice++
                return parte.replace(',', '.').toDoubleOrNull()
            }
        }

        return Analizador().calcularExpresion()
    }

    private fun formatear(numero: Double): String
    {
        return String.format(
            Locale.US,
            "%.8f",
            numero
        )
            .trimEnd('0')
            .trimEnd('.')
            .replace('.', ',')
    }
}
