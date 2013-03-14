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

import org.codehaus.jackson.map.ObjectMapper;
import org.gatein.pc.api.PortletInvoker;
import org.gatein.pc.embed.EmbedPhase;
import org.gatein.pc.embed.EmbedServlet;
import org.gatein.pc.embed.FragmentData;
import org.gatein.pc.embed.Page;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

/**
 * todo: make it possible to handle several portlets at once
 *
 * @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a>
 */
public class RESTServlet extends EmbedServlet
{

   private final ObjectMapper mapper = new ObjectMapper(); // ObjectMapper is thread-safe for use, but configuring it is not
//   private final Encoder encoder = DefaultEncoder.getInstance();

   @Override
   protected EmbedPhase.Render getRenderPhase(Page page, PortletInvoker invoker, HashMap<String, String[]> parameters, HttpServletRequest req, HttpServletResponse resp)
   {
      return new RESTRenderPhase(page, invoker, parameters, req, resp);
   }

   private class RESTRenderPhase extends EmbedPhase.Render
   {
      RESTRenderPhase(Page page, PortletInvoker invoker, HashMap<String, String[]> parameters, HttpServletRequest req, HttpServletResponse resp)
      {
         super(page, invoker, parameters, req, resp);
      }

      @Override
      protected void preInvoke()
      {
         if (page.getNumberOfWindows() > 1)
         {
            throw new RuntimeException("RESTServlet render method only knows how to render a single portlet at a time");
         }
      }

      @Override
      protected void outputResponse(List<FragmentData> fragments, PrintWriter writer)
      {
         try
         {
            // there should only be one FragmentData as guarded by preInvoke
            final FragmentData data = fragments.get(0);

            mapper.writeValue(writer, data);
         }
         catch (IOException e)
         {
            throw new RuntimeException("Couldn't output JSON.", e);
         }
      }


      @Override
      protected void setContentType()
      {
         resp.setContentType("application/json;charset=utf-8");
      }


      @Override
      protected String encodeIfNeeded(String text)
      {
//         return text != null ? encoder.encodeForJavaScript(text) : text;
         return text;
      }
   }
}
