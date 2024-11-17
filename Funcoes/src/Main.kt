/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 *
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 *
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia: String) {
    if (!materiasENotas.containsKey(materia)) {
        println("Materia $materia não encontrada")
    } else {
        val listaNotas = materiasENotas[materia]
        if (listaNotas != null && listaNotas.isNotEmpty()) {
            var cont = 1
            var soma = 0.0
            for (nota in listaNotas) {
                println("Nota $cont: $nota")
                soma += nota
                cont++
            }
            val media = soma / listaNotas.size
            println("Média: $media \n")
        } else {
            println("Não foi possível mostrar as notas da matéria $materia")
        }
    }
}

/*Retorna a média obtida apartir de uma lista de notas */
fun calcularMedia(notas: MutableList<Double>): Double {
    return if (notas.isNotEmpty()) {
        val soma = notas.sum()
        soma / notas.size
    } else {
        0.0
    }
}

/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia: String, vararg notas: Double): Boolean {
    val listaNotas = materiasENotas[materia]
    return if (listaNotas != null) {
        listaNotas.addAll(notas.toList()) // Converter o vararg para uma lista
        true
    } else {
        false
    }
}


fun main(){
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional

    adicionarDisciplina("Matematica", mutableListOf(5.0, 6.5, 7.0))

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada

    adicionarDisciplina(materia = "Fisica", notas = mutableListOf(8.0, 7.5))

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()


    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas

    adicionarDisciplina("Biologia") // Notas são vazias por padrão

    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas

    adicionarNota("Matematica", 9.0)
    adicionarNota("Fisica", 7.5)
    adicionarNota("Biologia", 8.5)

    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas

    mostrarNotas("Matematica")
    mostrarNotas("Fisica")
    mostrarNotas("Biologia")

// 7. adicionarDisciplina -> adicione mais 1 disciplina

    adicionarDisciplina("Historia", mutableListOf(6.0, 7.0))

    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();

    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar

    adicionarVariasNotas("Historia", 6.0, 7.5, 8.0)

    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;

    mostrarNotas("Historia")

    // Bônus: (Não vai ganhar nada, ou melhor mais ganhar mais conhecimento >:O)

    // 11: calcularMedia -> Implemente a função calcularMedia()

    // 12: calcularMedia -> calcule a media de 2 disciplinas

    val mediaFisica = calcularMedia(materiasENotas["Fisica"] ?: mutableListOf())
    println("Média de Física: $mediaFisica \n")

    val mediaMatematica = calcularMedia(materiasENotas["Matematica"] ?: mutableListOf())
    println("Média de Matemática: $mediaMatematica \n")

    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas

    // 14: mostrarNotas -> mostre as notas de 1 disciplina

    mostrarNotas("Fisica")
}