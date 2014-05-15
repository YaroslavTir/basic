package org.openehealth.tutorial

import org.apache.camel.model.ProcessorType

class SampleModelExtension {

     static extensions = {
         
         ProcessorType.metaClass.reverse = {
             delegate.transmogrify { it.reverse() }
         }

         ProcessorType.metaClass.setFileHeaderFrom = { String sourceHeader ->
             delegate.setHeader('org.apache.camel.file.name') { exchange ->
                 def destination = exchange.in.headers."$sourceHeader"
                 destination ? "${destination}.txt" : 'default.txt'
             }
         }
         
     }
     
}
