import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.modes.SICBlockCipher;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class BcModeTestFile {

    public void encryptAESCBCPKCS7(byte[] key, byte[] iv) {
        AESEngine aes = AESEngine.newInstance(); // Noncompliant {{AES}}
        CBCBlockCipher cbc = CBCBlockCipher.newInstance(aes); // Noncompliant {{AES-CBC}}
        PKCS7Padding padding = new PKCS7Padding(); // Noncompliant {{PKCS7}}

        cbc.init(true, new ParametersWithIV(new KeyParameter(key), iv));
        return;
    }

    public void decryptAESCTR(byte[] key, byte[] iv) {
        AESEngine aes = AESEngine.newInstance(); // Noncompliant {{AES}}
        SICBlockCipher ctr = new SICBlockCipher(aes); // Noncompliant {{AES-CTR}}

        ctr.init(false, new ParametersWithIV(new KeyParameter(key), iv));
        return;
    }
}
