package com.poveda.training_bank.clientes.infratest;

import java.io.IOException;
import java.util.List;

public interface SceneryStrategy {

    List<SceneryLoaderHelper.Scenery> parser(final String json) throws IOException;

}
