import os
from flask import Flask, url_for, jsonify, request, render_template
from flask.ext.bootstrap import Bootstrap
from flask.ext.sqlalchemy import SQLAlchemy

basedir = os.path.abspath(os.path.dirname(__file__))
db_path = os.path.join(basedir, '../data.sqlite')

app = Flask(__name__)
bootstrap = Bootstrap(app)
app.config['SQLALCHEMY_DATABASE_URI'] = 'sqlite:///' + db_path

db = SQLAlchemy(app)


class ValidationError(ValueError):
    pass


class Course(db.Model):
    __tablename__ = 'courses'
    Title = db.Column(db.Text)
    Status = db.Column(db.Text)
    Type = db.Column(db.Text)
    CRN = db.Column(db.Integer, primary_key=True)
    Unit = db.Column(db.Text)
    Meet = db.Column(db.Text)
    Meeting_Time = db.Column(db.Text)
    Location = db.Column(db.Text)
    Cap = db.Column(db.Integer)
    Act = db.Column(db.Integer)
    Rem = db.Column(db.Integer)
    Instructor = db.Column(db.Text)
    Date = db.Column(db.Text)
    Weeks = db.Column(db.Integer)

    def get_url(self):
        return url_for('get_course', CRN=self.CRN, _external=True)

    def export_data(self):
        return {
            'self_url': self.get_url(),
            'Title': self.Title,
            'Status': self.Status,
            'Type': self.Type,
            'CRN': self.CRN,
            'Unit': self.Unit,
            'Meet': self.Meet,
            'Meeting_Time': self.Meeting_Time,
            'Location': self.Location,
            'Cap': self.Cap,
            'Act': self.Act,
            'Rem': self.Rem,
            'Instructor': self.Instructor,
            'Date': self.Date,
            'Weeks': self.Weeks
        }

    def import_data(self, data):
        try:
            self.Title = data['Title']
        except KeyError as e:
            raise ValidationError('Invalid course: missing ' + e.args[0])
        return self


@app.route('/courses/', methods=['GET'])
def get_courses():
    return jsonify({'courses': [course.get_url() for course in
                                  Course.query.all()]})

@app.route('/courses/<int:CRN>', methods=['GET'])
def get_course(CRN):
    return jsonify(Course.query.get_or_404(CRN).export_data())

@app.route('/courses/', methods=['POST'])
def new_student():
    course = Course()
    course.import_data(request.json)
    db.session.add(course)
    db.session.commit()
    return jsonify({}), 201, {'Location': course.get_url()}

@app.route('/courses/<int:CRN>', methods=['PUT'])
def edit_student(CRN):
    course = Course.query.get_or_404(CRN)
    course.import_data(request.json)
    db.session.add(course)
    db.session.commit()
    return jsonify({})

# todo: implement this template
@app.errorhandler(404)
def not_found(e):
    return render_template('404.html')

@app.route('/')
def index():
    highlight = {'min': 1, 'max': 2}
    courses = Course.query.all()
    return render_template('index.html', courses=courses, highlight=highlight)

if __name__ == '__main__':
    db.create_all()
    app.run(debug=True)
