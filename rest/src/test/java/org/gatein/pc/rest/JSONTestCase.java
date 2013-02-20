/*
* JBoss, a division of Red Hat
* Copyright 2012, Red Hat Middleware, LLC, and individual contributors as indicated
* by the @authors tag. See the copyright.txt in the distribution for a
* full listing of individual contributors.
*
* This is free software; you can redistribute it and/or modify it
* under the terms of the GNU Lesser General Public License as
* published by the Free Software Foundation; either version 2.1 of
* the License, or (at your option) any later version.
*
* This software is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
* Lesser General Public License for more details.
*
* You should have received a copy of the GNU Lesser General Public
* License along with this software; if not, write to the Free
* Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
* 02110-1301 USA, or see the FSF site: http://www.fsf.org.
*/
package org.gatein.pc.rest;

import junit.framework.TestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.gatein.pc.embed.FragmentData;

import java.io.File;
import java.io.IOException;
import java.util.List;

/** @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a> */
public class JSONTestCase extends TestCase
{
   public void testRoundTrip() throws IOException
   {
      final FragmentData data = new FragmentData();
      final FragmentData.Head.Script script = new FragmentData.Head.Script();
      script.setSrc("http://example.com/foo/bar/file.ext?query+param=value");
      data.getHead().addScript(script);


      ObjectMapper mapper = new ObjectMapper();
      final File tempFile = File.createTempFile("test", "json");
      tempFile.deleteOnExit();
      mapper.writeValue(tempFile, data);

      final FragmentData readData = mapper.readValue(tempFile, FragmentData.class);
      final List<FragmentData.Head.Script> scripts = readData.getHead().getScripts();
      assertNotNull(scripts);
      assertEquals(1, scripts.size());
      assertEquals(script.getSrc(), scripts.get(0).getSrc());
   }
}
