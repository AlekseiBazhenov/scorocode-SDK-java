package ru.profit_group.scorocode_sdk.Requests.folders;

import ru.profit_group.scorocode_sdk.Requests.application.AppBase;
import ru.profit_group.scorocode_sdk.scorocode_objects.ScorocodeCoreInfo;

/**
 * Created by Peter Staranchuk on 11/21/16
 */

public class RequestCreateNewFolder extends AppBase {

    private String path;

    public RequestCreateNewFolder(ScorocodeCoreInfo stateHolder, String path) {
        super(stateHolder);
        this.path = path;
    }
}
