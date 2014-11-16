package name.neuhalfen.padding_oracle

import spock.lang.Specification

class CipherTextTest extends Specification {
    def "Clone copies all arrays"() {
        given:

        CipherText original = new CipherText("iv".getBytes(), "ciphertext".getBytes(), "hmac".getBytes())

        when:
        CipherText clone = original.clone()
        clone.iv[0] = (byte)'X'
        clone.ciphertext[0] = (byte)'Y'
        clone.hmac[0] = (byte)'Z'

        then:
        original.iv[0] == (byte)'i'
        original.ciphertext[0] == (byte)'c'
        original.hmac[0] == (byte)'h'
    }
}
