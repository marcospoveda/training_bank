package com.poveda.training_bank.clientes.infratest

import com.google.common.collect.Lists
import org.apache.commons.io.FilenameUtils
import org.apache.commons.lang3.builder.EqualsBuilder
import org.apache.commons.io.IOUtils
import org.apache.commons.lang3.builder.ToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle


class SceneryLoaderHelper {

    List<Scenery> scenarios = Lists.newArrayList()

    static Map<String, SceneryStrategy> sceneryStrategy = new HashMap<>()

    static {
        sceneryStrategy.put("json", new JsonScenery())
    }

    SceneryLoaderHelper(){}

    void load(String... files) throws IOException {
        for (String fileName : files) {
            def fileFullName = "/jsonunit/${fileName}"
            def stream = SceneryLoaderHelper.class.getResourceAsStream(fileFullName)
            if (stream == null) {
                throw new IllegalArgumentException("Scenario file [" + fileName +"] not found")
            }

            def encoding = System.getProperty("file.encoding")
            final def json = IOUtils.toString(stream, encoding)
            //System.out.println(json)
            final def extension = FilenameUtils.getExtension(fileName)
            //System.out.println(extension)

            if (!sceneryStrategy.containsKey(extension)) {
                throw new RuntimeException("File type not supported: " + extension)
            }
            final def sceneriesToInsert = sceneryStrategy.get(extension).parser(json)
            //System.out.println(sceneriesToInsert)

            for(SceneryLoaderHelper.Scenery scenery : sceneriesToInsert) {
                scenery.file = fileFullName
                if(scenarios.contains(scenery)) {
                    throw new RuntimeException("Scenario '" + scenery.getDescription() + "' already exists")
                }
                scenarios.add(scenery)
            }
        }

    }

    def getRequestScenery(String description) {

        int indexOf = scenarios.indexOf(SceneryLoaderHelper.ExternalEquals.externalEquals(description))

        if (indexOf > -1) {
            return scenarios.get(indexOf)
        }

        throw new IllegalArgumentException("Scenario not found [" + description +"]" + scenarios)
    }

    static class Scenery {


        private String description
        private String file
        private String json

        Scenery() {
        }

        Scenery(String description) {
            this.description = description
        }

        String getJson() {
            return json
        }

        def setJson(String json) {
            this.json = json
        }

        def getDescription() {
            return description
        }

        def setDescription(String description) {
            this.description = description
        }

        String getFile() {
            return file
        }

        void setFile(String file) {
            this.file = file
        }

        String toString() {
            return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE)
        }

        @Override
        boolean equals(Object o) {
            EqualsBuilder.reflectionEquals(o, this, "json")
        }

        @Override
        int hashCode() {
            return description != null ? description.hashCode() : 0
        }
    }

    private static class ExternalEquals {

        private final Scenery scenery

        ExternalEquals(String description) {
            this.scenery = new Scenery(description)
        }

        static ExternalEquals externalEquals(String description) {
            return new ExternalEquals(description)
        }

        @Override
        boolean equals(Object e) {
            if (e == null) {
                return Boolean.FALSE
            }
            if (!(e instanceof Scenery)) {
                return Boolean.FALSE
            }
            Scenery sceneryParam = (Scenery) e

            if (sceneryParam.getDescription().equalsIgnoreCase(this.scenery.getDescription()) &&
                    !this.scenery.file.equals(sceneryParam.file)) {
                return Boolean.TRUE
            }

            return Boolean.FALSE
        }
    }

}
