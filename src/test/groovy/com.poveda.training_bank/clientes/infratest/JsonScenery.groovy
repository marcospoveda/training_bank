package com.poveda.training_bank.clientes.infratest

import com.google.gson.GsonBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import net.minidev.json.JSONArray

class JsonScenery {

    @SuppressWarnings("all")
    def parser(final String json) {
        def scenariosList = new JsonSlurper().parseText(json)

        def scenarios = scenariosList.collect {
            def scenery = new SceneryLoaderHelper.Scenery();
            scenery.setDescription(it["cenario"]);
            def jsonFound = it["json"];

            if (jsonFound instanceof JSONArray) {
                scenery.setJson(jsonFound.toString())
            } else {
                scenery.setJson(JsonOutput.toJson(jsonFound))
            }
            return scenery
        }

        return scenarios;
    }

}
