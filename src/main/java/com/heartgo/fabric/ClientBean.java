package com.heartgo.fabric;

import com.heartgo.utils.SampleOrg;
import org.hyperledger.fabric.sdk.ChaincodeID;
import org.hyperledger.fabric.sdk.HFClient;
import org.hyperledger.fabric.sdk.*;

public class ClientBean
{
    private HFClient client;
    private Channel channel;
    private ChaincodeID chaincodeid;
    private SampleOrg sampleorg;
    private RunChannel runchannel;
    public ClientBean(HFClient client,Channel channel,ChaincodeID chaincodeid,SampleOrg sampleorg,RunChannel runchannel){
        this.chaincodeid=chaincodeid;
        this.channel=channel;
        this.client=client;
        this.runchannel=runchannel;
        this.sampleorg=sampleorg;
    }
    public ClientBean(HFClient client,ChaincodeID chaincodeid,SampleOrg sampleorg,RunChannel runchannel){
        this.chaincodeid=chaincodeid;
        this.client=client;
        this.runchannel=runchannel;
        this.sampleorg=sampleorg;
    }
    public void setClient(HFClient client){
        this.client=client;
    }
    public HFClient getClient(){
        return client;
    }
    public void setChannel(Channel channel){
        this.channel=channel;
    }
    public Channel getChannel() {
        return channel;
    }

    public void setChaincodeid(ChaincodeID chaincodeid){
        this.chaincodeid=chaincodeid;
    }
    public ChaincodeID getChaincodeid(){
        return chaincodeid;
    }
    public void setSampleorg(SampleOrg sampleorg){
        this.sampleorg=sampleorg;
    }
    public SampleOrg  getSampleorg(){
        return sampleorg;
    }
    public void setRunchannel(RunChannel runchannel){
        this.runchannel=runchannel;
    }
    public RunChannel getRunchannel() {
        return runchannel;
    }
}
