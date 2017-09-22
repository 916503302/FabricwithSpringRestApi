package com.heartgo.service;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.errorprone.annotations.Var;
import com.heartgo.model.Transaction;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.json.Json;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class TransactionService {
    private List<Transaction> transaction;


    String transactionTest = "[{\"transactionid\":\"0\",\"transactiondate\":\"1505806838\",\"parentorder\":\"0\",\"suborder\":\"0\",\"payid\":\"0\",\"transtype\":\"0\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"0\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"1\",\"transactiondate\":\"1505806838\",\"parentorder\":\"1\",\"suborder\":\"1\",\"payid\":\"1\",\"transtype\":\"1\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"1\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"2\",\"transactiondate\":\"1505806838\",\"parentorder\":\"2\",\"suborder\":\"2\",\"payid\":\"2\",\"transtype\":\"2\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"2\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"3\",\"transactiondate\":\"1505806838\",\"parentorder\":\"3\",\"suborder\":\"3\",\"payid\":\"3\",\"transtype\":\"3\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"3\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"4\",\"transactiondate\":\"1505806838\",\"parentorder\":\"4\",\"suborder\":\"4\",\"payid\":\"4\",\"transtype\":\"4\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"4\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"5\",\"transactiondate\":\"1505806838\",\"parentorder\":\"5\",\"suborder\":\"5\",\"payid\":\"5\",\"transtype\":\"5\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"5\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"6\",\"transactiondate\":\"1505806838\",\"parentorder\":\"6\",\"suborder\":\"6\",\"payid\":\"6\",\"transtype\":\"6\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"6\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"7\",\"transactiondate\":\"1505806838\",\"parentorder\":\"7\",\"suborder\":\"7\",\"payid\":\"7\",\"transtype\":\"7\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"7\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"8\",\"transactiondate\":\"1505806838\",\"parentorder\":\"8\",\"suborder\":\"8\",\"payid\":\"8\",\"transtype\":\"8\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"8\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"9\",\"transactiondate\":\"1505806838\",\"parentorder\":\"9\",\"suborder\":\"9\",\"payid\":\"9\",\"transtype\":\"9\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"9\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"10\",\"transactiondate\":\"1505806838\",\"parentorder\":\"10\",\"suborder\":\"10\",\"payid\":\"10\",\"transtype\":\"10\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"10\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"11\",\"transactiondate\":\"1505806838\",\"parentorder\":\"11\",\"suborder\":\"11\",\"payid\":\"11\",\"transtype\":\"11\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"11\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"12\",\"transactiondate\":\"1505806838\",\"parentorder\":\"12\",\"suborder\":\"12\",\"payid\":\"12\",\"transtype\":\"12\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"12\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"13\",\"transactiondate\":\"1505806838\",\"parentorder\":\"13\",\"suborder\":\"13\",\"payid\":\"13\",\"transtype\":\"13\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"13\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"14\",\"transactiondate\":\"1505806838\",\"parentorder\":\"14\",\"suborder\":\"14\",\"payid\":\"14\",\"transtype\":\"14\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"14\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"15\",\"transactiondate\":\"1505806838\",\"parentorder\":\"15\",\"suborder\":\"15\",\"payid\":\"15\",\"transtype\":\"15\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"15\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"16\",\"transactiondate\":\"1505806838\",\"parentorder\":\"16\",\"suborder\":\"16\",\"payid\":\"16\",\"transtype\":\"16\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"16\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"17\",\"transactiondate\":\"1505806838\",\"parentorder\":\"17\",\"suborder\":\"17\",\"payid\":\"17\",\"transtype\":\"17\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"17\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"18\",\"transactiondate\":\"1505806838\",\"parentorder\":\"18\",\"suborder\":\"18\",\"payid\":\"18\",\"transtype\":\"18\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"18\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"19\",\"transactiondate\":\"1505806838\",\"parentorder\":\"19\",\"suborder\":\"19\",\"payid\":\"19\",\"transtype\":\"19\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"19\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"20\",\"transactiondate\":\"1505806838\",\"parentorder\":\"20\",\"suborder\":\"20\",\"payid\":\"20\",\"transtype\":\"20\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"20\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"21\",\"transactiondate\":\"1505806838\",\"parentorder\":\"21\",\"suborder\":\"21\",\"payid\":\"21\",\"transtype\":\"21\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"21\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"22\",\"transactiondate\":\"1505806838\",\"parentorder\":\"22\",\"suborder\":\"22\",\"payid\":\"22\",\"transtype\":\"22\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"22\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"23\",\"transactiondate\":\"1505806838\",\"parentorder\":\"23\",\"suborder\":\"23\",\"payid\":\"23\",\"transtype\":\"23\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"23\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"24\",\"transactiondate\":\"1505806838\",\"parentorder\":\"24\",\"suborder\":\"24\",\"payid\":\"24\",\"transtype\":\"24\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"24\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"25\",\"transactiondate\":\"1505806838\",\"parentorder\":\"25\",\"suborder\":\"25\",\"payid\":\"25\",\"transtype\":\"25\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"25\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"26\",\"transactiondate\":\"1505806838\",\"parentorder\":\"26\",\"suborder\":\"26\",\"payid\":\"26\",\"transtype\":\"26\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"26\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"27\",\"transactiondate\":\"1505806838\",\"parentorder\":\"27\",\"suborder\":\"27\",\"payid\":\"27\",\"transtype\":\"27\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"27\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"28\",\"transactiondate\":\"1505806838\",\"parentorder\":\"28\",\"suborder\":\"28\",\"payid\":\"28\",\"transtype\":\"28\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"28\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"29\",\"transactiondate\":\"1505806838\",\"parentorder\":\"29\",\"suborder\":\"29\",\"payid\":\"29\",\"transtype\":\"29\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"29\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"30\",\"transactiondate\":\"1505806838\",\"parentorder\":\"30\",\"suborder\":\"30\",\"payid\":\"30\",\"transtype\":\"30\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"30\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"31\",\"transactiondate\":\"1505806838\",\"parentorder\":\"31\",\"suborder\":\"31\",\"payid\":\"31\",\"transtype\":\"31\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"31\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"32\",\"transactiondate\":\"1505806838\",\"parentorder\":\"32\",\"suborder\":\"32\",\"payid\":\"32\",\"transtype\":\"32\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"32\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"33\",\"transactiondate\":\"1505806838\",\"parentorder\":\"33\",\"suborder\":\"33\",\"payid\":\"33\",\"transtype\":\"33\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"33\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"34\",\"transactiondate\":\"1505806838\",\"parentorder\":\"34\",\"suborder\":\"34\",\"payid\":\"34\",\"transtype\":\"34\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"34\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"35\",\"transactiondate\":\"1505806838\",\"parentorder\":\"35\",\"suborder\":\"35\",\"payid\":\"35\",\"transtype\":\"35\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"35\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"36\",\"transactiondate\":\"1505806838\",\"parentorder\":\"36\",\"suborder\":\"36\",\"payid\":\"36\",\"transtype\":\"36\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"36\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"37\",\"transactiondate\":\"1505806838\",\"parentorder\":\"37\",\"suborder\":\"37\",\"payid\":\"37\",\"transtype\":\"37\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"37\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"38\",\"transactiondate\":\"1505806838\",\"parentorder\":\"38\",\"suborder\":\"38\",\"payid\":\"38\",\"transtype\":\"38\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"38\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"39\",\"transactiondate\":\"1505806838\",\"parentorder\":\"39\",\"suborder\":\"39\",\"payid\":\"39\",\"transtype\":\"39\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"39\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"40\",\"transactiondate\":\"1505806838\",\"parentorder\":\"40\",\"suborder\":\"40\",\"payid\":\"40\",\"transtype\":\"40\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"40\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"41\",\"transactiondate\":\"1505806838\",\"parentorder\":\"41\",\"suborder\":\"41\",\"payid\":\"41\",\"transtype\":\"41\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"41\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"42\",\"transactiondate\":\"1505806838\",\"parentorder\":\"42\",\"suborder\":\"42\",\"payid\":\"42\",\"transtype\":\"42\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"42\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"43\",\"transactiondate\":\"1505806838\",\"parentorder\":\"43\",\"suborder\":\"43\",\"payid\":\"43\",\"transtype\":\"43\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"43\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"44\",\"transactiondate\":\"1505806838\",\"parentorder\":\"44\",\"suborder\":\"44\",\"payid\":\"44\",\"transtype\":\"44\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"44\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"45\",\"transactiondate\":\"1505806838\",\"parentorder\":\"45\",\"suborder\":\"45\",\"payid\":\"45\",\"transtype\":\"45\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"45\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"46\",\"transactiondate\":\"1505806838\",\"parentorder\":\"46\",\"suborder\":\"46\",\"payid\":\"46\",\"transtype\":\"46\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"46\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"47\",\"transactiondate\":\"1505806838\",\"parentorder\":\"47\",\"suborder\":\"47\",\"payid\":\"47\",\"transtype\":\"47\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"47\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"48\",\"transactiondate\":\"1505806838\",\"parentorder\":\"48\",\"suborder\":\"48\",\"payid\":\"48\",\"transtype\":\"48\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"48\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"49\",\"transactiondate\":\"1505806838\",\"parentorder\":\"49\",\"suborder\":\"49\",\"payid\":\"49\",\"transtype\":\"49\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"49\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"50\",\"transactiondate\":\"1505806838\",\"parentorder\":\"50\",\"suborder\":\"50\",\"payid\":\"50\",\"transtype\":\"50\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"50\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"51\",\"transactiondate\":\"1505806838\",\"parentorder\":\"51\",\"suborder\":\"51\",\"payid\":\"51\",\"transtype\":\"51\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"51\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"52\",\"transactiondate\":\"1505806838\",\"parentorder\":\"52\",\"suborder\":\"52\",\"payid\":\"52\",\"transtype\":\"52\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"52\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"53\",\"transactiondate\":\"1505806838\",\"parentorder\":\"53\",\"suborder\":\"53\",\"payid\":\"53\",\"transtype\":\"53\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"53\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"54\",\"transactiondate\":\"1505806838\",\"parentorder\":\"54\",\"suborder\":\"54\",\"payid\":\"54\",\"transtype\":\"54\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"54\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"55\",\"transactiondate\":\"1505806838\",\"parentorder\":\"55\",\"suborder\":\"55\",\"payid\":\"55\",\"transtype\":\"55\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"55\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"56\",\"transactiondate\":\"1505806838\",\"parentorder\":\"56\",\"suborder\":\"56\",\"payid\":\"56\",\"transtype\":\"56\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"56\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"57\",\"transactiondate\":\"1505806838\",\"parentorder\":\"57\",\"suborder\":\"57\",\"payid\":\"57\",\"transtype\":\"57\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"57\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"58\",\"transactiondate\":\"1505806838\",\"parentorder\":\"58\",\"suborder\":\"58\",\"payid\":\"58\",\"transtype\":\"58\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"58\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"59\",\"transactiondate\":\"1505806838\",\"parentorder\":\"59\",\"suborder\":\"59\",\"payid\":\"59\",\"transtype\":\"59\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"59\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"60\",\"transactiondate\":\"1505806838\",\"parentorder\":\"60\",\"suborder\":\"60\",\"payid\":\"60\",\"transtype\":\"60\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"60\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"61\",\"transactiondate\":\"1505806838\",\"parentorder\":\"61\",\"suborder\":\"61\",\"payid\":\"61\",\"transtype\":\"61\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"61\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"62\",\"transactiondate\":\"1505806838\",\"parentorder\":\"62\",\"suborder\":\"62\",\"payid\":\"62\",\"transtype\":\"62\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"62\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"63\",\"transactiondate\":\"1505806838\",\"parentorder\":\"63\",\"suborder\":\"63\",\"payid\":\"63\",\"transtype\":\"63\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"63\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"64\",\"transactiondate\":\"1505806838\",\"parentorder\":\"64\",\"suborder\":\"64\",\"payid\":\"64\",\"transtype\":\"64\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"64\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"65\",\"transactiondate\":\"1505806838\",\"parentorder\":\"65\",\"suborder\":\"65\",\"payid\":\"65\",\"transtype\":\"65\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"65\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"66\",\"transactiondate\":\"1505806838\",\"parentorder\":\"66\",\"suborder\":\"66\",\"payid\":\"66\",\"transtype\":\"66\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"66\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"67\",\"transactiondate\":\"1505806838\",\"parentorder\":\"67\",\"suborder\":\"67\",\"payid\":\"67\",\"transtype\":\"67\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"67\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"68\",\"transactiondate\":\"1505806838\",\"parentorder\":\"68\",\"suborder\":\"68\",\"payid\":\"68\",\"transtype\":\"68\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"68\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"69\",\"transactiondate\":\"1505806838\",\"parentorder\":\"69\",\"suborder\":\"69\",\"payid\":\"69\",\"transtype\":\"69\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"69\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"70\",\"transactiondate\":\"1505806838\",\"parentorder\":\"70\",\"suborder\":\"70\",\"payid\":\"70\",\"transtype\":\"70\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"70\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"71\",\"transactiondate\":\"1505806838\",\"parentorder\":\"71\",\"suborder\":\"71\",\"payid\":\"71\",\"transtype\":\"71\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"71\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"72\",\"transactiondate\":\"1505806838\",\"parentorder\":\"72\",\"suborder\":\"72\",\"payid\":\"72\",\"transtype\":\"72\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"72\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"73\",\"transactiondate\":\"1505806838\",\"parentorder\":\"73\",\"suborder\":\"73\",\"payid\":\"73\",\"transtype\":\"73\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"73\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"74\",\"transactiondate\":\"1505806838\",\"parentorder\":\"74\",\"suborder\":\"74\",\"payid\":\"74\",\"transtype\":\"74\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"74\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"75\",\"transactiondate\":\"1505806838\",\"parentorder\":\"75\",\"suborder\":\"75\",\"payid\":\"75\",\"transtype\":\"75\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"75\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"76\",\"transactiondate\":\"1505806838\",\"parentorder\":\"76\",\"suborder\":\"76\",\"payid\":\"76\",\"transtype\":\"76\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"76\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"77\",\"transactiondate\":\"1505806838\",\"parentorder\":\"77\",\"suborder\":\"77\",\"payid\":\"77\",\"transtype\":\"77\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"77\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"78\",\"transactiondate\":\"1505806838\",\"parentorder\":\"78\",\"suborder\":\"78\",\"payid\":\"78\",\"transtype\":\"78\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"78\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9},{\"transactionid\":\"79\",\"transactiondate\":\"1505806838\",\"parentorder\":\"79\",\"suborder\":\"79\",\"payid\":\"79\",\"transtype\":\"79\",\"fromtype\":1,\"fromid\":\"NdhcINGG\",\"totype\":1,\"toid\":\"NdhcINGG\",\"productid\":\"79\",\"productinfo\":\"wegoodi%3\",\"organizationid\":\"pingan\",\"amount\":4,\"price\":9}]";


    // Love Java 8
    public List<Transaction> findByUserName(String organizationid) {

        List<Transaction> results = transaction.stream()
                .filter(x -> x.getOrganizationid().equalsIgnoreCase(organizationid))
                .collect(Collectors.toList());

        return results;

    }

    @PostConstruct
    private void iniDataForTesting() {

        var obj = transactionTest.parseJSON(); //由JSON字符串转换为JSON对象

        transaction = new ArrayList<Transaction>();



//        Transaction transaction1 = new Transaction("1",
//                "2017/09/01 00:00:00",
//                "2",
//                "3",
//                "4",
//                "5",
//                6,
//                "NdhcINGG",
//                7,
//                "NdhcINGG",
//                "8",
//                "交易信息为11111",
//                "pingan",
//                9,
//                10);
////        Transaction transaction2 = new Transaction("yflow", "password222", "yflow@yahoo.com");
////        Transaction transaction3 = new Transaction("laplap", "password333", "mkyong@yahoo.com");
//        Transaction transaction2 = new Transaction("a",
//                "2017/09/7 04:00:00",
//                "b",
//                "c",
//                "d",
//                "e",
//                11,
//                "NdhcINGG",
//                22,
//                "NdhcINGG",
//                "8",
//                "交易信息为3333",
//                "pingan",
//                9,
//                10);
//        Transaction transaction3 = new Transaction("1",
//                "2017/09/19 02:00:00",
//                "2",
//                "3",
//                "4",
//                "5",
//                6,
//                "NdhcINGG",
//                7,
//                "NdhcINGG",
//                "8",
//                "交易信息为3333",
//                "pingan",
//                9,
//                10);
//        transaction.add(transaction1);
//        transaction.add(transaction2);
//        transaction.add(transaction3);
//
//    }


    }
}