package org.openehealth.tutorial

import org.apache.camel.model.ProcessorType


     static extensions = {
         
         ProcessorType.metaClass.reverse = {
             delegate.transmogrify { it.reverse() }
         }
         
     }
     
}