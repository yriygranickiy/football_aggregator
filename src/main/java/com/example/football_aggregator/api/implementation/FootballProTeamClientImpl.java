package com.example.football_aggregator.api.implementation;


//
//@SuperBuilder
//public  class FootballProTeamClientImpl  extends FootballApiClient {
//
//    @Override
//    public List<? extends ResponseApiTeam> getTeam(Map<String,String> param){
//
//        String result = "";
//
//        String responseList = "";
//
//        List<FootballProResponseApiTeam> responseCommandList = new ArrayList<>();
//
//        Request request = buildRequest("/teams/search"+ UtillitiesParam
//                .buildParam(param));
//
//        try {
//            Response response = client.newCall(request).execute();
//
//            result = Objects.requireNonNull(response.body()).string();
//
//            ObjectMapper mapper = new ObjectMapper();
//
//            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//            JsonNode node = mapper.readTree(result);
//
//            responseList = node.path("data").toString();
//
//            responseCommandList = mapper.readValue(responseList, new TypeReference<List<FootballProResponseApiTeam>>() {});
//
//            if(responseCommandList.isEmpty()){
//                throw new ApiRequestException("this team not found");
//            }else {
////                return responseCommandList;
//            }
//        } catch (IOException e) {
//            e.getMessage();
//        }
//        //update later
//        return null;
//    }

