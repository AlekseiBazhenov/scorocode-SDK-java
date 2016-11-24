package ru.profit_group.scorocode_sdk.Requests.folders;

import ru.profit_group.scorocode_sdk.Requests.application.AppBase;
import ru.profit_group.scorocode_sdk.scorocode_objects.ScorocodeSdkStateHolder;

/**
 * Created by Peter Staranchuk on 11/21/16
 */

public class RequestFoldersList extends AppBase {

    private String path;

    public RequestFoldersList(ScorocodeSdkStateHolder stateHolder, String path) {
        super(stateHolder);
        this.path = path;
    }
}