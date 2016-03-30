public class Bureaucrat extends CityWorker
{
    public Bureaucrat(City parentCity,Building home)
    {
        super(AbstractPerson.Type.Bureaucrat,parentCity,home);
    }

}