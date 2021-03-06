/*
 * Licensed Materials - Property of IBM
 * 
 * (c) Copyright IBM Corp. 2019.
 */
package test.zos3270.datastream;

import java.util.ArrayList;

import org.apache.commons.codec.binary.Hex;
import org.junit.Assert;
import org.junit.Test;

import dev.galasa.zos3270.TerminalInterruptedException;
import dev.galasa.zos3270.internal.datastream.AbstractQueryReply;
import dev.galasa.zos3270.internal.datastream.QueryReplySummary;
import dev.galasa.zos3270.internal.datastream.QueryReplyUsableArea;
import dev.galasa.zos3270.spi.Screen;

public class QueryReplySummaryTest {

    @Test
    public void testGoldenPath() throws TerminalInterruptedException {
        Screen screen = new Screen(80, 24, null);

        QueryReplyUsableArea qrua = new QueryReplyUsableArea(screen);

        ArrayList<AbstractQueryReply> replies = new ArrayList<>();
        replies.add(qrua);

        QueryReplySummary qrs = new QueryReplySummary(replies);

        String shouldBe = Hex.encodeHexString(new byte[] { (byte) 0x00, // Length1
                (byte) 0x06, // Length2
                (byte) 0x81, // Query Reply
                (byte) 0x80, // Summary
                (byte) 0x80, // Summary
                (byte) 0x81 // Usable Area
        });

        String actual = Hex.encodeHexString(qrs.toByte());

        Assert.assertEquals("response from Usable area is incorrect", shouldBe, actual);

    }

}
