package org.astivetoolkit.examples.astivejs;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.MaryAudioUtils;
import org.apache.commons.codec.binary.Hex;

import javax.sound.sampled.AudioInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by psanders on 12/1/14.
 */
public class TTSHelper {

    private static final TTSHelper INSTANCE = new TTSHelper();
    private MaryInterface marytts;

    private TTSHelper()  {
        try {
            marytts = new LocalMaryInterface();
        } catch(MaryConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void generate(String text) throws MaryConfigurationException, SynthesisException, IOException, NoSuchAlgorithmException {
        String filename = getFilename(text);

        if (new File(filename).exists()) return;

        AudioInputStream audio = marytts.generateAudio(text);
        MaryAudioUtils.writeWavFile(MaryAudioUtils.getSamplesAsDoubleArray(audio), filename, audio.getFormat());
    }

    // Try the call this just one time once
    public String getFilename(String text) throws NoSuchAlgorithmException {
        final MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.reset();
        messageDigest.update(text.getBytes(Charset.forName("UTF8")));
        final byte[] resultByte = messageDigest.digest();
        final String r = new String(Hex.encodeHex(resultByte));
        return "/tmp/" + r + ".wav";
    }

    public static TTSHelper getInstance() {
        return INSTANCE;
    }

}

