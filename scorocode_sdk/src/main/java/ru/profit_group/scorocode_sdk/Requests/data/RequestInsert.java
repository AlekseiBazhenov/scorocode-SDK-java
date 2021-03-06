package ru.profit_group.scorocode_sdk.Requests.data;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.HashMap;

import ru.profit_group.scorocode_sdk.scorocode_objects.DocumentInfo;
import ru.profit_group.scorocode_sdk.scorocode_objects.ScorocodeCoreInfo;

/**
 * Created by Peter Staranchuk on 5/10/16
 */
public class RequestInsert {
    private String app;
    private String cli;
    private String acc;
    private String sess;
    private String coll;
    private HashMap<String, Object> doc;

    public RequestInsert(
            @NonNull ScorocodeCoreInfo stateHolder,
            @NonNull String collectionName,
            @Nullable DocumentInfo doc) {
        this.app = stateHolder.getApplicationId();
        this.cli = stateHolder.getClientKey();
        this.acc = stateHolder.getMasterKey();
        this.sess = stateHolder.getSessionId();
        this.coll = collectionName;
        this.doc = doc.getFields();
    }
}
