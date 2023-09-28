#include <sstream>
#include <string>
#include <iostream>
#include <fstream>
#include <array>
#include <vector>
#include <algorithm>
using namespace std;

bool isBottomSame(vector<vector<int>> temp_vec, int x, int y);
bool isRightSame(vector<vector<int>> temp_vec, int x, int y);       //define those here so they can visible to each other
bool isLeftSame(vector<vector<int>> temp_vec, int x, int y);
bool isTopSame(vector<vector<int>> temp_vec, int x, int y);

int gsize = 0;
vector<vector<int>> temp_index_vector;                      //global variables and array
int bomb_gsize = 0;
int score = 0;

string readFileIntoString(ifstream& input_file) { //read the text file
    return string((istreambuf_iterator<char>(input_file)), istreambuf_iterator<char>());
}

vector<string> getStringArray(string my_string){ //convert string which is file content to string vector
    vector<string> string_vector;
    stringstream ss(my_string);
    string temp;
    while(getline(ss, temp, '\n')){
        string_vector.push_back(temp);
      }
    return string_vector;
}

vector<vector<int>> getGrid(vector<string> my_string_vector){  //convert strings to integers
    vector<vector<int>> vect(my_string_vector.size()-1, vector<int> (3, 0));
    string st = my_string_vector[0];
    gsize = stoi(st);
    vector<string> str_vect;
    
    for(int i = 1; i < my_string_vector.size(); i++){
        stringstream ss(my_string_vector[i]);
        string temp;
        while(getline(ss, temp, ' ')){
            str_vect.push_back(temp);
        }
    }
    int k = 0;
    for(int i = 0; i < my_string_vector.size() - 1; i++){
        for(int j = 0; j < 3; j++){
            vect[i][j] = stoi(str_vect[k++]);
        }
    }
    return vect;
}

bool isRightSame(vector<vector<int>> temp_vec, int x, int y){      //check the right index of the given value
    
    if((y+1 != gsize) && (temp_vec[x][y] == temp_vec[x][y+1])){
        vector<int> local_remember = {x, y+1};
        temp_index_vector.push_back(local_remember);
        local_remember.clear();
        
        isRightSame(temp_vec, x, y+1);
        isTopSame(temp_vec, x, y+1);                                //call right, top and bottom sides
        isBottomSame(temp_vec, x, y+1);
        return true;
    }
    return false;
}

bool isLeftSame(vector<vector<int>> temp_vec, int x, int y){        //check the left index of the given value
    
    if((y != 0) && (temp_vec[x][y] == temp_vec[x][y-1])){
        vector<int> local_remember = {x, y-1};
        temp_index_vector.push_back(local_remember);
        local_remember.clear();
        
        isLeftSame(temp_vec, x, y-1);
        isTopSame(temp_vec, x, y-1);                                //call left, top and bottom sides
        isBottomSame(temp_vec, x, y-1);
        return true;
    }
    return false;
}

bool isTopSame(vector<vector<int>> temp_vec, int x, int y){         //check the top index of the given value
    
    if((x != 0) && (temp_vec[x][y] == temp_vec[x-1][y])){
        vector<int> local_remember = {x-1, y};
        temp_index_vector.push_back(local_remember);
        local_remember.clear();
        
        isTopSame(temp_vec, x-1, y);
        isRightSame(temp_vec, x-1, y);                              //call top, right and left sides
        isLeftSame(temp_vec, x-1, y);

        return true;
    }
    return false;
}

bool isBottomSame(vector<vector<int>> temp_vec, int x, int y){      //check  the bottom index of the given value
    
    if((x+1 != gsize) && (temp_vec[x][y] == temp_vec[x+1][y])){
        vector<int> local_remember = {x+1, y};
        temp_index_vector.push_back(local_remember);
        local_remember.clear();
        
        isBottomSame(temp_vec, x+1, y);
        isRightSame(temp_vec, x+1, y);                              //call bottom, right and left sides
        isLeftSame(temp_vec, x+1, y);
        return true;
    }
    return false;
}

vector<vector<int>> gridFunction(vector<vector<int>> my_grid_vector){       //return the last version of the 2d vector
    vector<vector<int>> last_grid_vector(gsize, vector<int> (gsize,0));
    
    for(int i = 0; i < my_grid_vector.size(); i++){
        int val = my_grid_vector[i][0];
        int x = my_grid_vector[i][1];
        int y = my_grid_vector[i][2];
        last_grid_vector[x][y] = val;
        
        if(isRightSame(last_grid_vector, x, y)){};
        if(isLeftSame(last_grid_vector, x, y)){};                 //call all of the check functions
        if(isTopSame(last_grid_vector, x, y)){};
        if(isBottomSame(last_grid_vector, x, y)){};
        
        
        for(int lastThing = 0; lastThing < gsize; lastThing++){
            if(temp_index_vector.size() >= 2){
                for(int deg = 0; deg < temp_index_vector.size(); deg++){
                    last_grid_vector[temp_index_vector[deg][0]][temp_index_vector[deg][1]] = 0;
                }
                last_grid_vector[x][y] = ++val;
                temp_index_vector.clear();
                if(isRightSame(last_grid_vector, x, y)){};
                if(isLeftSame(last_grid_vector, x, y)){};                 //call all of the functions for gsize times
                if(isTopSame(last_grid_vector, x, y)){};
                if(isBottomSame(last_grid_vector, x, y)){};
            }
        }
        temp_index_vector.clear();
    }
    
    return last_grid_vector;
}

vector<vector<int>> getBombGrid(vector<string> my_bomb_string_vector){      //get the bomb array
    string st = my_bomb_string_vector[0];
    bomb_gsize = stoi(st);
    vector<vector<int>> bomb_vect(bomb_gsize, vector<int> (bomb_gsize, 0));
    
    vector<string> str_vect;                                                //string to integers
    
    for(int i = 1; i <= bomb_gsize; i++){
        stringstream ss(my_bomb_string_vector[i]);
        string temp;
        while(getline(ss, temp, ' ')){
            str_vect.push_back(temp);
        }
    }
    
    int k = 0;
    for(int i = 0; i < bomb_gsize; i++){
        for(int j = 0; j < bomb_gsize; j++){
            bomb_vect[i][j] = stoi(str_vect[k++]);
        }
    }
    
    
    return bomb_vect;
}

vector<vector<int>> getBombIndex(vector<string> my_bomb_string_vector){             //get the bomb indices into the another array
    vector<vector<int>> bomb_index_vect(my_bomb_string_vector.size() - bomb_gsize - 1, vector<int> (2, 0));
    
    vector<string> str_vect;
    
    for(int i = (bomb_gsize + 1); i <= (my_bomb_string_vector.size() - 1); i++){
        stringstream ss(my_bomb_string_vector[i]);
        string temp;
        while(getline(ss, temp, ' ')){
            str_vect.push_back(temp);                                               //string to integers
        }
    }
    
    int k = 0;
    for(int i = 0; i < (my_bomb_string_vector.size() - bomb_gsize - 1); i++){
        for(int j = 0; j < 2; j++){
            bomb_index_vect[i][j] = stoi(str_vect[k++]);
        }
    }
    
    
    return bomb_index_vect;
}

void bombGridFunction(vector<vector<int>> &my_bomb_vector, vector<vector<int>> bomb_index_vector){          //give address of the array
    for(int i = 0; i < bomb_index_vector.size(); i++){                                                      //so its elements can be changed
        int xx = bomb_index_vector[i][0];
        int yy = bomb_index_vector[i][1];
        int bomb_value = my_bomb_vector[xx][yy];
        score += bomb_value;
        
        int txx = xx;                       //temporary bomb indices
        int tyy = yy;
        while((txx > 0) && (tyy < bomb_gsize-1)){
            if(my_bomb_vector[txx-1][tyy+1] == bomb_value){
                score += bomb_value;
                my_bomb_vector[txx-1][tyy+1] = 0;
            }
            txx--;
            tyy++;
        }
        txx = xx;
        tyy = yy;
        while((txx > 0) && (tyy > 0)){
            if(my_bomb_vector[txx-1][tyy-1] == bomb_value){
                score += bomb_value;
                my_bomb_vector[txx-1][tyy-1] = 0;
            }
            txx--;
            tyy--;
        }
        txx = xx;
        tyy = yy;
        while((txx < bomb_gsize-1) && (tyy < bomb_gsize-1)){
            if(my_bomb_vector[txx+1][tyy+1] == bomb_value){
                score += bomb_value;
                my_bomb_vector[txx+1][tyy+1] = 0;
            }
            txx++;
            tyy++;
        }
        txx = xx;
        tyy = yy;
        while((txx < bomb_gsize-1) && (tyy > 0)){
            if(my_bomb_vector[txx+1][tyy-1] == bomb_value){
                score += bomb_value;
                my_bomb_vector[txx+1][tyy-1] = 0;
            }
            txx++;
            tyy--;
        }
        txx = xx;
        tyy = yy;
        
        while(txx > 0){
            if(my_bomb_vector[txx-1][tyy] == bomb_value){
                score += bomb_value;
                my_bomb_vector[txx-1][tyy] = 0;
            }
            txx--;
        }
        txx = xx;
        while(txx < bomb_gsize-1){
            if(my_bomb_vector[txx+1][tyy] == bomb_value){
                score += bomb_value;
                my_bomb_vector[txx+1][tyy] = 0;
            }
            txx++;
        }
        txx = xx;
        while(tyy > 0){
            if(my_bomb_vector[txx][tyy-1] == bomb_value){
                score += bomb_value;
                my_bomb_vector[txx][tyy-1] = 0;
            }
            tyy--;
        }
        tyy = yy;
        while(tyy < bomb_gsize-1){
            if(my_bomb_vector[txx][tyy+1] == bomb_value){
                score += bomb_value;
                my_bomb_vector[txx][tyy+1] = 0;
            }
            tyy++;
        }
        tyy = yy;
        
        my_bomb_vector[xx][yy] = 0;
    }
}

int main(int argc, char** argv){
    
    ifstream my_file(argv[1]);
    string my_string = "";
    my_string = readFileIntoString(my_file);
    vector<string> my_string_vector = getStringArray(my_string);
  
    vector<vector<int>> my_vector;
    my_vector = getGrid(my_string_vector);
    vector<vector<int>> my_grid_vector = gridFunction(my_vector);               //write that into the output file

    ifstream my_bomb_file(argv[2]);
    string my_bomb_string = "";
    my_bomb_string = readFileIntoString(my_bomb_file);
    vector<string> my_bomb_string_vector = getStringArray(my_bomb_string);
    
    vector<vector<int>> my_bomb_vector;
    my_bomb_vector = getBombGrid(my_bomb_string_vector);            //bomb_gsize x bomb_gsize sized array
    
    vector<vector<int>> bomb_index_vector;                          //bombs indices
    bomb_index_vector = getBombIndex(my_bomb_string_vector);
    
    bombGridFunction(my_bomb_vector, bomb_index_vector);            //call the last version of the 2d array
    
    ofstream my_output_file(argv[3]);
    my_output_file << "PART1:" << endl;                             //writing to the file
    for(int i = 0; i < gsize; i++){
        for(int j = 0; j < gsize; j++){
            my_output_file << my_grid_vector[i][j] << " ";
        }
        my_output_file << endl;
    }
    my_output_file << endl;
    my_output_file << "PART2:" << endl;
    for(int i = 0; i < bomb_gsize; i++){
        for(int j = 0; j < bomb_gsize; j++){
            my_output_file << my_bomb_vector[i][j] << " ";
        }
        my_output_file << endl;
    }
    my_output_file << "Final Point: " << score << "p";
}
