package se.guard.test;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;


public class Example
{
    public Example(String templateFile)
    {
        try
        {
            /*
             * setup
             */

            Velocity.init("/sources/velocity/velocity.properties");
            
            /*
             *  Make a context object and populate with the data.  This 
             *  is where the Velocity engine gets the data to resolve the
             *  references (ex. $list) in the template
             */

            VelocityContext context = new VelocityContext();
            context.put("list", getNames());
            
            /*
             *  get the Template object.  This is the parsed version of your 
             *  template input file.  Note that getTemplate() can throw
             *   ResourceNotFoundException : if it doesn't find the template
             *   ParseErrorException : if there is something wrong with the VTL
             *   Exception : if something else goes wrong (this is generally
             *        indicative of as serious problem...)
             */

            Template template =  null;

            try 
            {
                template = Velocity.getTemplate(templateFile);
            }
            catch( ResourceNotFoundException rnfe )
            {
                System.out.println("Example : error : cannot find template " + templateFile );
            }
            catch( ParseErrorException pee )
            {
                System.out.println("Example : Syntax error in template " + templateFile + ":" + pee );
            }

            /*
             *  Now have the template engine process your template using the
             *  data placed into the context.  Think of it as a  'merge' 
             *  of the template and the data to produce the output stream.
             */

            BufferedWriter writer = writer = new BufferedWriter(
                new OutputStreamWriter(System.out));

            if ( template != null)
                template.merge(context, writer);

            /*
             *  flush and cleanup
             */

            writer.flush();
            writer.close();
        }
        catch( Exception e )
        {
            System.out.println(e);
        }
    }

    public ArrayList getNames()
    {
        ArrayList list = new ArrayList();

        list.add("ArrayList element 1");
        list.add("ArrayList element 2");
        list.add("ArrayList element 3");
        list.add("ArrayList element 4");

        return list;
    }

    public static void main(String[] args)
    {
        Example t = new Example("/sources/velocity/lost-password.vm");
    }
}