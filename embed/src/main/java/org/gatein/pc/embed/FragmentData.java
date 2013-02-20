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

package org.gatein.pc.embed;

import java.util.ArrayList;
import java.util.List;

/** @author <a href="mailto:chris.laprun@jboss.com">Chris Laprun</a> */
public class FragmentData
{
   // Accessors are required for potential data binding, proper support for properties in Java would be nice here :)

   String body;
   Head head = new Head();

   public String getBody()
   {
      return body;
   }

   public void setBody(String body)
   {
      this.body = body;
   }

   public Head getHead()
   {
      return head;
   }

   public void setHead(Head head)
   {
      this.head = head;
   }

   public static class Head
   {
      List<Style> styles = new ArrayList<Style>(3);
      List<Script> scripts = new ArrayList<Script>(3);
      List<Meta> metas = new ArrayList<Meta>(3);
      List<Link> links = new ArrayList<Link>(3);
      String title;

      public void addStyle(Style style)
      {
         styles.add(style);
      }

      public void addScript(Script script)
      {
         scripts.add(script);
      }

      public void addMeta(Meta meta)
      {
         metas.add(meta);
      }

      public void addLink(Link link)
      {
         links.add(link);
      }

      public List<Style> getStyles()
      {
         return styles;
      }

      public void setStyles(List<Style> styles)
      {
         this.styles = styles;
      }

      public List<Script> getScripts()
      {
         return scripts;
      }

      public void setScripts(List<Script> scripts)
      {
         this.scripts = scripts;
      }

      public List<Meta> getMetas()
      {
         return metas;
      }

      public void setMetas(List<Meta> metas)
      {
         this.metas = metas;
      }

      public List<Link> getLinks()
      {
         return links;
      }

      public void setLinks(List<Link> links)
      {
         this.links = links;
      }

      public String getTitle()
      {
         return title;
      }

      public void setTitle(String title)
      {
         this.title = title;
      }

      public static class Style
      {
         String type;
         String media;
         String text;

         public String getType()
         {
            return type;
         }

         public void setType(String type)
         {
            this.type = type;
         }

         public String getMedia()
         {
            return media;
         }

         public void setMedia(String media)
         {
            this.media = media;
         }

         public String getText()
         {
            return text;
         }

         public void setText(String text)
         {
            this.text = text;
         }
      }

      public static class Script
      {
         String src;
         String type;
         String text;

         public String getSrc()
         {
            return src;
         }

         public void setSrc(String src)
         {
            this.src = src;
         }

         public String getType()
         {
            return type;
         }

         public void setType(String type)
         {
            this.type = type;
         }

         public String getText()
         {
            return text;
         }

         public void setText(String text)
         {
            this.text = text;
         }
      }

      public static class Meta
      {
         String http_equiv;
         String name;
         String content;
         String charset; // HTML5

         public String getCharset()
         {
            return charset;
         }

         public void setCharset(String charset)
         {
            this.charset = charset;
         }

         public String getHttp_equiv()
         {
            return http_equiv;
         }

         public void setHttp_equiv(String http_equiv)
         {
            this.http_equiv = http_equiv;
         }

         public String getName()
         {
            return name;
         }

         public void setName(String name)
         {
            this.name = name;
         }

         public String getContent()
         {
            return content;
         }

         public void setContent(String content)
         {
            this.content = content;
         }
      }

      public static class Link
      {
         String charset;
         String href;
         String media;
         String rel;
         String type;

         public String getCharset()
         {
            return charset;
         }

         public void setCharset(String charset)
         {
            this.charset = charset;
         }

         public String getHref()
         {
            return href;
         }

         public void setHref(String href)
         {
            this.href = href;
         }

         public String getMedia()
         {
            return media;
         }

         public void setMedia(String media)
         {
            this.media = media;
         }

         public String getRel()
         {
            return rel;
         }

         public void setRel(String rel)
         {
            this.rel = rel;
         }

         public String getType()
         {
            return type;
         }

         public void setType(String type)
         {
            this.type = type;
         }
      }
   }

}
