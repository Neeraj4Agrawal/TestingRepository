#!/usr/bin/env groovy

pipeline 
{
	agent any
	stages 
	{
		stage('checkout')
		{
			steps
			{
				checkout scm
			}
		}
		stage('check java') 
		{
			steps
			{
				sh "java -version"
			}		
		}
		stage('clean') 
		{
			steps
			{
				sh "chmod +x mvnw"
				sh "./mvnw clean"
			}
		}
		stage('test-run') 
		{
			steps
			{
				sh "./mvnw -PRunAll verify -e -fae"
			}
		}
		stage('generate-cucumber-report') 
		{
			steps
			{	
				cucumber buildStatus: 'UNSTABLE',    
		        fileIncludePattern: '**/*.json',
		        jsonReportDirectory: 'target',
		        trendsLimit: 10,
		        classifications:[
		        					[
		                        		'key': 'Browser','value': 'Chrome'
		                        	]
		                		]
		   	}
		 }
	}
	post {  
         always {
			 emailext body: '$DEFAULT_CONTENT', from: '', mimeType: 'text/html', replyTo: '', subject: '$DEFAULT_SUBJECT', to: "gajendra.rawat@cgt.co.in,santosh.kumar@cgt.co.in,automated.testing@brideside.com";
         }
     }
}