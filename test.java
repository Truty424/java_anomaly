import java.util.Arrays;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.engines.AESWrapEngine;
import org.bouncycastle.crypto.params.KeyParameter;

public class BcWrapUnwrapExample {
    public static void main(String[] args) throws Exception {
        byte[] kek = new byte[16];
        byte[] keyToWrap = new byte[16];

        Arrays.fill(kek, (byte) 0x11);
        Arrays.fill(keyToWrap, (byte) 0x22);

        Wrapper wrapper = new AESWrapEngine();

        wrapper.init(true, new KeyParameter(kek));
        byte[] wrapped = wrapper.wrap(keyToWrap, 0, keyToWrap.length);

        wrapper.init(false, new KeyParameter(kek));
        byte[] unwrapped = wrapper.unwrap(wrapped, 0, wrapped.length);

        System.out.println("wrapped len = " + wrapped.length);
        System.out.println("unwrapped len = " + unwrapped.length);
    }
}
