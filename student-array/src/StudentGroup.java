import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		return this.students;
	
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		return this.students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
		this.students[index]=student;
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
		int numOfStudents = this.students.length;
		for(int i=numOfStudents-1;i>=0;i--){
			this.students[i+1]=this.students[i];
		}
		this.students[0]=student;
		this.students[numOfStudents+1]=null;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		this.students[students.length]=student;
		this.students[students.length+1]=null;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		int numOfStudents=this.students.length;
		for(int j=numOfStudents;j>index;j--)
		this.students[j]=this.students[j-1];
		this.students[index]=student;
		this.students[numOfStudents+1]=null;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		int numOfStudents=this.students.length;
		for(int j=index;j<numOfStudents;j++)
		this.students[j]=this.students[j+1];
		this.students[numOfStudents+1]=null;
		
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		int i=this.students.length;
		int index=0;
        for(int j=0;j<i;j++)
        	if(this.students[j].equals(student))
        	{	
        		index=j;
        		break;
        	}
        for(int j=index;j<i;j++)
        	this.students[j]=this.students[j+1];
        this.students[i+1]=null;
		
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
		int i=this.students.length;
		this.students[index]=null;
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		int i=this.students.length;
		int index=0;
        for(int j=0;j<i;j++)
        	if((this.students[j]).equals(student))
        	{
        		index=j;
        		break;
        	}
		this.students[index]=null;
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		int j=this.students.length;
		for(int i=0; i<= j-index;i++)
			this.students[i]=this.students[i+index+1];
		this.students[j+1]=null;
 
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		int i=this.students.length;
		int index=0;
        for(int j=0;j<i;j++)
        	if((this.students[j]).equals(student))
        	{
        		index=j;
        		break;
             }
		int j=this.students.length;
		for(i=0;i<=j-index;i++)
			this.students[i]=this.students[i+index+1];
		this.students[i+1]=null;
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		 for (int a = 1; a < students.length; a++) {
		        for (int b = 0; b < students.length - a; b++) {
		            if (((students[b])
		                    .compareTo((students[b + 1]))) > 0) {
		                Student temp = students[b];
		                students[b] = students[b + 1];
		                students[b + 1] = temp;
		            }
		        }
		    }
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		Student studentDOB = new Student[students.length];
		for(int i=0,j=0;i<students.length;i++){
			if(students[i].getBirthDate()==date){
				studentDOB[j]=students[i];
				j++;
			}
		}
		return studentDOB;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		Student studentDOB = new Student[students.length];
		for(int i=0,j=0;i<students.length;i++){
			if(students[i].getBirthDate()>=firstDate && students[i].getBirthDate()<=lastDate){
				studentDOB[j]=students[i];
				j++;
			}
		}
		return studentDOB;

	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		Date date = new Date();
		String bDate= new SimpleDateFormat("yyyy-MM-dd").format(students[indexOfStudent].getbirthDate());

		String modifiedDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		 try {
	         Date   d1 = format.parse(bDate);
	          Date  d2 = format.parse(modifiedDate);

	            //in milliseconds
	            int diff = d2.getTime() - d1.getTime();

	            int diffDays = diff / (24 * 60 * 60 * 1000);

	            	return diffDays/365;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
		Student studentAge = new Student[students.length];
		for(int i=0,j=0;i<students.length;i++){
			if(students[i].getAge()==age ){
				studentAge[j]=students[i];
				j++;
			}
		}
		return studentAge;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		Student studentMaxAvg = new Student[students.length];
		double Max= -1;
		for(int i=0;i<students.length;i++){
			if(max<students[i].getAvgMark())
				max = avgMark;
		}
		for(int i=0,j=0;i<students.length;i++){
			if(max==students[i].getAvgMark()){
				studentMaxAvg[j]=students[i];
				j++;
			}
		}
	 
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		int i=this.students.length;
		int index1=0;
        for(int j=0;j<i;j++)
        	if((this.students[j]).equals(student))
        	{
        		index1=j;
        		break;
            }
        return this.students[index1+1];
	}
}
