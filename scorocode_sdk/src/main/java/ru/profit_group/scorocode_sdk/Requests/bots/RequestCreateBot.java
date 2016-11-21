package ru.profit_group.scorocode_sdk.Requests.bots;

import ru.profit_group.scorocode_sdk.Requests.application.AppBase;
import ru.profit_group.scorocode_sdk.scorocode_objects.ScorocodeBot;

/**
 * Created by Peter Staranchuk on 11/21/16
 */

public class RequestCreateBot extends AppBase {

    private ScorocodeBot bot;

    public RequestCreateBot(String masterKey, String applicationId, ScorocodeBot bot) {
        super(masterKey, applicationId);
        this.bot = bot;
    }
}
