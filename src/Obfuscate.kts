#!/usr/bin/env kscript

import java.lang.System.exit
import kotlin.random.Random




fun random(size :Int) : IntArray{
    val outpout = IntArray(size)
    for (i in 0 until size){
        outpout[i]= Random.nextInt()
    }
    return outpout
}

val stringToHide = args[0]

val stringToProcess = stringToHide.map{it.toInt()}.toIntArray()

val cypher = random(stringToProcess.size)
val xor  = StringBuilder()
for(i in 0 until stringToProcess.size){
    xor.append((stringToProcess[i] xor cypher[i]).toChar())
}

val returnedxor = xor.map { it.toInt() }.toIntArray().contentToString().removeSurrounding("[","]")
val returnedCipher = cypher.contentToString().removeSurrounding("[","]")


println("\u001B[0;32mOriginal\u001B[0;0m")
println(args[0])
val returnedString ="""
    fun decryptWithCypher(cypher: IntArray, xor: IntArray): String {
        val output = StringBuilder()

        for (i in 0 until cypher.size) {
            output.append((cypher[i] xor xor[i]).toChar())
        }

        return output.toString()
    }

    // de-obfuscation
    val cipher =  intArrayOf(${returnedCipher})
    val xor = intArrayOf($returnedxor)

    // returns "original"
    return decryptWithCypher(cipher, xor)
    """
println("\u001B[0;32mObfuscated code\u001B[0;0m")
println(returnedString)
exit(0)