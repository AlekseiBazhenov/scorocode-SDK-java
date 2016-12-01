package ru.profit_group.scorocode_sdk;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import ru.profit_group.scorocode_sdk.Callbacks.CallbackCreateScript;
import ru.profit_group.scorocode_sdk.Callbacks.CallbackSendScript;
import ru.profit_group.scorocode_sdk.scorocode_objects.ScorocodeScript;
import ru.profit_group.scorocode_sdk.scorocode_objects.Script;


import static ru.profit_group.scorocode_sdk.ScorocodeTestHelper.printError;

/**
 * Created by Peter Staranchuk on 10/21/16
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ScorocodeSdkTestScriptClass {

    @BeforeClass
    public static void setUp() throws Exception {
        ScorocodeSdk.initWith(ScorocodeTestHelper.getAppId(), ScorocodeTestHelper.getClientKey(), ScorocodeTestHelper.getMasterKey(), null, null, null, null);
    }

    @Test
    public void test1SendScript() throws InterruptedException {
        Script script = new Script();

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        script.runScript(ScorocodeTestHelper.ANY_REAL_SCRIPT_ID, new CallbackSendScript() {
            @Override
            public void onScriptSended() {
                countDownLatch.countDown();
            }

            @Override
            public void onScriptSendFailed(String errorCode, String errorMessage) {
                printError("не удалось отправить скрипт на исполнение", errorCode, errorMessage);
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();
    }

    @Test
    public void test2SendScript() throws InterruptedException {
        Script script = new Script();

        final CountDownLatch countDownLatch = new CountDownLatch(1);

        Map<String, Object> dataPull = new HashMap<>();
        dataPull.put("collname", "items");
        dataPull.put("key", "exampleField");
        dataPull.put("val", "any text");


        script.runScript(ScorocodeTestHelper.ANY_REAL_SCRIPT_ID, dataPull, new CallbackSendScript() {
            @Override
            public void onScriptSended() {
                countDownLatch.countDown();
            }

            @Override
            public void onScriptSendFailed(String errorCode, String errorMessage) {
                printError("не удалось отправить скрипт на исполнение", errorCode, errorMessage);
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();
    }

    @Test
    public void test3CreateScript() throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(1);

        ScorocodeScript script = new ScorocodeScript()
                .setScriptName("scorocodeScriptForTest.js")
                .setScriptPath("/scorocodePathForTest1.js")
                .setScriptSourceCode("hello world")
                .setScriptDescription("script for test");

        ScorocodeSdk.createScript(script, new CallbackCreateScript() {
            @Override
            public void onScriptCreated(ScorocodeScript script) {
                countDownLatch.countDown();
            }

            @Override
            public void onCreationFailed(String errorCode, String errorMessage) {
                printError("test failed", errorCode, errorMessage);
                countDownLatch.countDown();
            }
        });

        countDownLatch.await();
    }


}
